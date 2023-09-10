package com.products.app.ui.splash.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.products.app.core.util.RequestState
import com.products.app.ui.resource.util.Route
import com.products.app.ui.splash.component.SplashScreenErrorWidget
import com.products.app.ui.splash.component.SplashScreenLoadingWidget
import com.products.app.ui.splash.controller.SplashScreenViewModel

@Composable
fun SplashScreen(navController: NavController, viewModel: SplashScreenViewModel = hiltViewModel()) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        when (state.getDataState) {
            is RequestState.Initializing -> SplashScreenLoadingWidget()
            is RequestState.Loading -> SplashScreenLoadingWidget()
            is RequestState.Failure -> SplashScreenErrorWidget(error = state.errorMsg)
            is RequestState.Success -> {
                // user needs to login
                if (state.loginNeeded) navController.navigate(Route.Login.route)

                // user data successfully loaded
                navController.navigate(Route.Products.route)
            }
        }
    }
}