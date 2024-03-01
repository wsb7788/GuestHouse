package com.guesthouse.login.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.guesthouse.login.ui.route.EMAIL_ROUTE
import com.guesthouse.login.ui.route.EmailRoute
import com.guesthouse.login.ui.route.LOGIN_ROUTE
import com.guesthouse.login.ui.route.LoginRoute

const val LOGIN_GRAPH_ROUTE = "login_graph_route"

fun NavGraphBuilder.loginGraph(
    navController: NavController
) {
    navigation(
        startDestination = LOGIN_ROUTE,
        route = LOGIN_GRAPH_ROUTE,
    ) {
        composable(route = LOGIN_ROUTE) {
            LoginRoute(
                navController = navController,
                onLoginClick = { navController.navigateToEmail() }
            )
        }

        composable(route = EMAIL_ROUTE) {
            EmailRoute(
                navController = navController
            )
        }

    }
}

fun NavController.navigateToEmail() {
    navigate(EMAIL_ROUTE)
}