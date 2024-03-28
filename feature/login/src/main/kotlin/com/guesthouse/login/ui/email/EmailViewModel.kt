package com.guesthouse.login.ui.email

import android.util.Log
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
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EmailViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(), EmailContract {

    private val _state: MutableStateFlow<EmailContract.State> =
        MutableStateFlow(EmailContract.State())
    override val state: StateFlow<EmailContract.State> = _state.asStateFlow()

    private val _effect: MutableSharedFlow<EmailContract.Effect> =
        MutableSharedFlow(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    override val effect: SharedFlow<EmailContract.Effect> = _effect.asSharedFlow()

    override fun event(event: EmailContract.Event) = when (event) {
        EmailContract.Event.OnLoginButtonClicked -> {
            loginWithEmail()
        }

        EmailContract.Event.OnFindPasswordButtonClicked -> {
            onFindPasswordButtonClicked()
        }

        is EmailContract.Event.OnEmailChanged -> onEmailChanged(email = event.email)
        is EmailContract.Event.OnPasswordChanged -> onPasswordChanged(password = event.password)
        EmailContract.Event.OnSignUpWithEmailButtonClicked -> onSignUpWithEmailButtonClicked()
        EmailContract.Event.OnSignUpContinueButtonClicked -> onSignUpContinueButtonClicked()
    }

    private fun loginWithEmail() {
        if(_state.value.loginForm.isValidEmail()){
            Log.d("TAG", "loginWithEmail: valid email")
        }else {
            Log.d("TAG", "loginWithEmail: inValid email!!!!!!!!")
        }
        if(_state.value.loginForm.isValidPassword()){
            Log.d("TAG", "loginWithEmail: valid password")
        }else {
            Log.d("TAG", "loginWithEmail: invalidPassword!!!!!!!!")
        }
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
                loginForm = it.loginForm.copy(
                    password = password
                )
            )
        }
    }

    private fun onEmailChanged(email: String) {
        _state.update {
            it.copy(
                loginForm = it.loginForm.copy(
                    email = email
                )
            )
        }
    }
}