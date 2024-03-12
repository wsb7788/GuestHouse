package com.guesthouse.login.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guesthouse.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

//    val loginUiState: StateFlow<LoginUiState> = loginUiState().stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5_000),
//        initialValue = LoginUiState.Loading
//    )
//
//    private fun loginUiState(): Flow<LoginUiState> {
//        loginUseCase().map {
//
//        }
//    }
}

sealed class LoginUiState<out T> {
    object Loading : LoginUiState<Nothing>()
    data class Success<T>(val data: T) : LoginUiState<T>()
    data class Error(val message: String) : LoginUiState<Nothing>()
}