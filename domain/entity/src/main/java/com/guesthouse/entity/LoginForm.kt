package com.guesthouse.entity

import java.util.regex.Pattern

data class LoginForm(
    val email: String = "",
    val password: String = "",
){
    fun isValidEmail(): Boolean =
        Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", email)

    fun isValidPassword(): Boolean =
        Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,20}$", password)
}
