package com.guesthouse.usecase

import com.guesthouse.entity.Login
import com.guesthouse.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    operator fun invoke(): Flow<Login> {
        return loginRepository.getLoginInfo()
    }
}