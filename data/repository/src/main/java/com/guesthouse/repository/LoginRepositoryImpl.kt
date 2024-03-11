package com.guesthouse.repository

import com.guesthouse.datasource.LoginDataSource
import com.guesthouse.entity.Login
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource
) : LoginRepository {
    override fun getLoginInfo(): Flow<Login> = flow {
        val networkLogin = loginDataSource.getLoginInfo()
        emit(
            Login(
                Login.Body(
                    networkLogin.body.email,
                    networkLogin.body.token,
                    networkLogin.body.imageUrl
                ), networkLogin.message, networkLogin.success
            )
        )
    }.flowOn(Dispatchers.IO)
}