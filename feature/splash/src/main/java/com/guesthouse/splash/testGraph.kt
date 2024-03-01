package com.guesthouse.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.guesthouse.splash.ui.TestRoute
import com.navigation.navigation.GhGraphRoute
import com.navigation.navigation.GhRoute

fun NavGraphBuilder.testGraph() {
    navigation(
        startDestination = GhRoute.TEST.name,
        route = GhGraphRoute.TEST_GRAPH.name,
    ) {
        composable(route = GhRoute.TEST.name) {
            TestRoute()
        }
    }
}