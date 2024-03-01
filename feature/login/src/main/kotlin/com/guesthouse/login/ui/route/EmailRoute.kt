package com.guesthouse.login.ui.route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.guesthouse.login.ui.screen.EmailScreen

const val EMAIL_ROUTE = "email_route"

@Composable
public fun EmailRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    EmailScreen()
}