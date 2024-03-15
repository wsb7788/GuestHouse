package com.guesthouse.login.ui.viewmodel

import com.guesthouse.base.BaseContract

interface LoginContract : BaseContract<LoginContract.State, LoginContract.Event, LoginContract.Effect> {
    data class State(
        val isLoading: Boolean = false,
        val email: String = "",
        val password: String = "",
        val rememberEmail: Boolean = false,
    )

    sealed interface Event {
        data object OnKakaoLoginButtonClicked : Event
        data object OnLoginButtonClicked : Event
        data object OnFindPasswordButtonClicked : Event

        data class OnEmailChanged(val email: String): Event
        data class OnPasswordChanged(val password: String): Event
    }

    sealed interface Effect {
        data object KakaoLogin : Effect
    }
}