package com.guesthouse.login.ui.email

import com.guesthouse.base.BaseContract

interface EmailContract
    : BaseContract<EmailContract.State, EmailContract.Event, EmailContract.Effect> {

    data class State(
        val isLoading: Boolean = false,
        val email: String = "",
        val password: String = "",
        val rememberEmail: Boolean = false,
    )

    sealed interface Event {
        data object OnLoginButtonClicked : Event
        data object OnFindPasswordButtonClicked : Event
        data class OnEmailChanged(val email: String): Event
        data class OnPasswordChanged(val password: String): Event
    }

    sealed interface Effect {
    }
}