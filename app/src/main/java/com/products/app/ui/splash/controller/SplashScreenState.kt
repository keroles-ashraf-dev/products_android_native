package com.products.app.ui.splash.controller

import com.products.app.core.util.RequestState

data class SplashScreenState(
    val getDataState: RequestState = RequestState.Loading,
    val loginNeeded: Boolean = true,
    val errorMsg: String = ""
)