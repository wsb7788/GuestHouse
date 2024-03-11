package com.guesthouse.datasource

import com.guesthouse.model.NetworkLogin

interface LoginDataSource {
    fun getLoginInfo(): NetworkLogin
}