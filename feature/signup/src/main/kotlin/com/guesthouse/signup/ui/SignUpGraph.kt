package com.guesthouse.signup.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.guesthouse.signup.ui.account.AccountRoute
import com.navigation.navigation.GhGraphRoute
import com.navigation.navigation.GhRoute

fun NavGraphBuilder.signUpGraph(
    navController: NavController,
) {
    navigation(
        startDestination = GhRoute.ACCOUNT.name,
        route = GhGraphRoute.SIGN_UP_GRAPH.name,
    ) {

        composable(route = GhRoute.ACCOUNT.name) {
            AccountRoute(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

    }
}