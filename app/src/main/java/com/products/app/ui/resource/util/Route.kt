package com.products.app.ui.resource.util

sealed class Route(val route: String) {
    object Splash : Route("main/splash")
    object Onboarding : Route("main/onboarding")
    object Login : Route("main/login")
    object Products : Route("main/products")
    object ProductDetails : Route("main/products/productDetails/{productId}")
}
