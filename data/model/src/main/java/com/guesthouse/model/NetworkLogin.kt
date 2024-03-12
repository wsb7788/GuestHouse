package com.guesthouse.model

data class NetworkLogin(
    val body: Body,
    val message: String,
    val success: Boolean,
) {
    data class Body(
        val email: String,
        val token: String,
        val imageUrl: String,
    )
}
