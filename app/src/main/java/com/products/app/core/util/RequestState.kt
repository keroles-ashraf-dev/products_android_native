package com.products.app.core.util

sealed class RequestState {
    object Initializing : RequestState()
    object Loading : RequestState()
    object Success : RequestState()
    object Failure : RequestState()
}
