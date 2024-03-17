package com.guesthouse.login.ui.login

import com.guesthouse.base.BaseContract

sealed interface LoginContract
    : BaseContract<LoginContract.State, LoginContract.Event, LoginContract.Effect> {
    data class State(
        val isLoading: Boolean = false,
    )

    sealed interface Event {
        data object OnKakaoLoginButtonClicked : Event
    }

    sealed interface Effect {
        data object KakaoLogin : Effect
    }
}