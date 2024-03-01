package com.guesthouse.login.ui.route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.guesthouse.login.ui.screen.LoginScreen

const val LOGIN_ROUTE = "login_route"

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
    onLoginClick:() -> Unit
) {
    LoginScreen(onLoginClick)
}