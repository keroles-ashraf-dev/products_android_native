package com.products.app.ui.products.controller

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.products.app.core.error.ErrorHandler
import com.products.app.core.util.RequestState
import com.products.app.domain.model.NoParams
import com.products.app.domain.usecase.product.SearchProductsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsScreenViewModel @Inject constructor(
    private val searchProductsUsecase: SearchProductsUsecase,
) : ViewModel() {

    private val _state = mutableStateOf(ProductsScreenState())
    val state: State<ProductsScreenState> = _state

    // events listener
    fun onEvent(event: SplashScreenEvent) {
        when (event) {
            is SplashScreenEvent.LoadData -> {
                handleUserLoginState()
            }
        }
    }

    // check user token in prefs if exists then get user data and navigate to home screen
    // else send request success and login needed state to navigate to login screen
    private fun handleUserLoginState() {
        val isLoggedIn = true

        if (isLoggedIn) return getUserData()

        _state.value = ProductsScreenState(getDataState = RequestState.Success, loginNeeded = true)
    }

    private fun getUserData() {
        viewModelScope.launch {
            try {
                _state.value = ProductsScreenState(getDataState = RequestState.Loading)

                val user = getUserUsecase(NoParams)

                _state.value =
                    ProductsScreenState(getDataState = RequestState.Success, loginNeeded = false)

            } catch (e: Exception) {
                _state.value = ProductsScreenState(
                    getDataState = RequestState.Failure,
                    errorMsg = ErrorHandler.handle(e)
                )
            }
        }
    }

}