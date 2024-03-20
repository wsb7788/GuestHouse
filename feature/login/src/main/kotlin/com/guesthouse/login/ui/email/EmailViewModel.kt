package com.guesthouse.login.ui.email

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EmailViewModel @Inject constructor(

): ViewModel(), EmailContract {

    private val _state: MutableStateFlow<EmailContract.State> = MutableStateFlow(EmailContract.State())
    override val state: StateFlow<EmailContract.State> = _state.asStateFlow()

    private val _effect: MutableSharedFlow<EmailContract.Effect> = MutableSharedFlow(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    override val effect: SharedFlow<EmailContract.Effect> = _effect.asSharedFlow()

    override fun event(event: EmailContract.Event) = when(event) {
        EmailContract.Event.OnLoginButtonClicked -> {
            Log.d("TAG", "event: ${state.value}")
            Unit
        }
        EmailContract.Event.OnFindPasswordButtonClicked -> {
            onFindPasswordButtonClicked()
        }
        is EmailContract.Event.OnEmailChanged -> onEmailChanged(email = event.email)
        is EmailContract.Event.OnPasswordChanged -> onPasswordChanged(password = event.password)
        EmailContract.Event.OnSignUpWithEmailButtonClicked -> onSignUpWithEmailButtonClicked()
        EmailContract.Event.OnSignUpContinueButtonClicked -> onSignUpContinueButtonClicked()
    }

    private fun onSignUpWithEmailButtonClicked() {


    }
    private fun onSignUpContinueButtonClicked() {
        _effect.tryEmit(EmailContract.Effect.NavigateToSignUp)
    }

    private fun onFindPasswordButtonClicked() {

    }

    private fun onPasswordChanged(password: String) {
        _state.update {
            it.copy(
                password = password
            )
        }
    }

    private fun onEmailChanged(email: String) {
        _state.update {
            it.copy(
                email = email
            )
        }
    }
}