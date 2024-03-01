package com.guesthouse.aos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.guesthouse.login.ui.loginGraph
import com.guesthouse.splash.testGraph
import com.navigation.navigation.GhGraphRoute

@Composable
internal fun GhNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = GhGraphRoute.LOGIN_GRAPH.name,
    ) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        loginGraph(navController = navController)
        testGraph()
    }
}

@Preview
@Composable
private fun Preview() {
    GhNavHost()
}
