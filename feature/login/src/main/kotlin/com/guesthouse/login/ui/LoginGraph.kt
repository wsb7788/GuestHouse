package com.guesthouse.login.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.guesthouse.login.ui.route.EmailRoute
import com.guesthouse.login.ui.route.LoginRoute
import com.navigation.navigation.GhGraphRoute
import com.navigation.navigation.GhRoute

fun NavGraphBuilder.loginGraph(
    navController: NavController,
) {
    navigation(
        startDestination = GhRoute.LOGIN.name,
        route = GhGraphRoute.LOGIN_GRAPH.name,
    ) {
        composable(route = GhRoute.LOGIN.name) {
            LoginRoute(
                onEmailLoginClick = { navController.navigateToEmail() }
            )
        }

        composable(route = GhRoute.EMAIL.name) {
            EmailRoute(
                onBackClick = navController::popBackStack
            )
        }

    }
}

fun NavController.navigateToEmail() {
    navigate(GhRoute.EMAIL.name)
}