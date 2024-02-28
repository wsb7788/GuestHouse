package com.guesthouse.login

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel(), LoginContract {

    private val _state: MutableStateFlow<LoginContract.State> = MutableStateFlow(LoginContract.State())
    override val state: StateFlow<LoginContract.State> = _state.asStateFlow()

    private val _effect: MutableSharedFlow<LoginContract.Effect> = MutableSharedFlow(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    override val effect: SharedFlow<LoginContract.Effect> = _effect.asSharedFlow()

    override fun event(event: LoginContract.Event) = when(event) {
        LoginContract.Event.OnKaKaoLoginClicked -> onKaKaoLoginClicked()
    }

    private fun onKaKaoLoginClicked() {

    }

}