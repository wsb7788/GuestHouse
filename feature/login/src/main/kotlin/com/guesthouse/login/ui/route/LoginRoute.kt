package com.guesthouse.login.ui.route

import androidx.compose.runtime.Composable
import com.guesthouse.login.ui.screen.LoginScreen

@Composable
fun LoginRoute(
    onLoginClick:() -> Unit
) {
    LoginScreen(onLoginClick)
}