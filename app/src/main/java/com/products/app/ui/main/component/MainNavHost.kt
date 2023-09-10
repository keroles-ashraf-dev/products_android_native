package com.products.app.ui.main.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.products.app.ui.login.screen.LoginScreen
import com.products.app.ui.onboarding.screen.OnboardingScreen
import com.products.app.ui.productDetails.screen.ProductDetailsScreen
import com.products.app.ui.products.screen.ProductsScreen
import com.products.app.ui.resource.util.Route
import com.products.app.ui.splash.screen.SplashScreen

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Splash.route
    ) {
        composable(route = Route.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Route.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = Route.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Route.Products.route) {
            ProductsScreen(navController = navController)
        }
        composable(
            route = Route.ProductDetails.route,
            arguments = listOf(
                navArgument(
                    name = "productId"
                ) {
                    type = NavType.IntType
                },
            )
        ) {
            val productId = it.arguments?.getInt("productId") ?: -1
            ProductDetailsScreen(
                navController = navController,
                productId = productId
            )
        }
    }
}