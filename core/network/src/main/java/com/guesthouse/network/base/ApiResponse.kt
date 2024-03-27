package com.guesthouse.network.base

data class ApiResponse<T>(
    val statusCode: Int?,
    val title: Int?,
    val message: String?,
    val data: T?
)