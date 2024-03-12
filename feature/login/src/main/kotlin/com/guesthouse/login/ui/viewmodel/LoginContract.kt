package com.guesthouse.login.ui.viewmodel

import com.guesthouse.base.BaseContract

interface LoginContract : BaseContract<LoginContract.State, LoginContract.Event, LoginContract.Effect> {
    data class State(
        val isLoading: Boolean = false
    )

    sealed interface Event {
        data object OnKakaoLoginClicked : Event
    }

    sealed interface Effect {
        data object KakaoLogin : Effect
    }
}