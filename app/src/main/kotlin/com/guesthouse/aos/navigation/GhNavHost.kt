package com.guesthouse.aos.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.guesthouse.login.ui.LOGIN_GRAPH_ROUTE
import com.guesthouse.login.ui.loginGraph

@Composable
internal fun GhNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = LOGIN_GRAPH_ROUTE,
    ) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        loginGraph(navController = navController)
    }
}

@Composable
private fun Preview() {
    GhNavHost()
}
