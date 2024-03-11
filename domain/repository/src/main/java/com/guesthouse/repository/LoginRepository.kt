package com.guesthouse.repository

import com.guesthouse.entity.Login
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun getLoginInfo(): Flow<Login>
}