package com.guesthouse.aos.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
internal fun GhMainRoute(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        modifier = modifier
    ) {
        GhNavHost(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            navController = navController
        )
    }
}

@Preview
@Composable
private fun Preview() = GhMainRoute()