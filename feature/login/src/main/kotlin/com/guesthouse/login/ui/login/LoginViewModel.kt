package com.guesthouse.login.ui.login

import androidx.lifecycle.ViewModel
import com.guesthouse.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(), LoginContract {

    private val _state: MutableStateFlow<LoginContract.State> = MutableStateFlow(LoginContract.State())
    override val state: StateFlow<LoginContract.State> = _state.asStateFlow()

    private val _effect: MutableSharedFlow<LoginContract.Effect> = MutableSharedFlow(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    override val effect: SharedFlow<LoginContract.Effect> = _effect.asSharedFlow()

    override fun event(event: LoginContract.Event) = when(event) {
        LoginContract.Event.OnKakaoLoginButtonClicked -> emitEffect(LoginContract.Effect.KakaoLogin)
        LoginContract.Event.OnEmailLoginButtonClicked -> emitEffect(LoginContract.Effect.EmailLogin)
    }

    private fun emitEffect(effect: LoginContract.Effect) {
        _effect.tryEmit(effect)
    }

}