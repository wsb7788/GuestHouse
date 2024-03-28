package com.guesthouse.login.ui.email

import com.guesthouse.base.BaseContract
import com.guesthouse.entity.LoginForm

sealed interface EmailContract
    : BaseContract<EmailContract.State, EmailContract.Event, EmailContract.Effect> {

    data class State(
        val isLoading: Boolean = false,
        val loginForm: LoginForm = LoginForm(),
        val rememberEmail: Boolean = false,
    )

    sealed interface Event {
        data object OnLoginButtonClicked : Event
        data object OnFindPasswordButtonClicked : Event
        data object OnSignUpWithEmailButtonClicked : Event
        data object OnSignUpContinueButtonClicked : Event

        data class OnEmailChanged(val email: String): Event
        data class OnPasswordChanged(val password: String): Event
    }

    sealed interface Effect {
        data object NavigateToSignUp : Effect
    }
}