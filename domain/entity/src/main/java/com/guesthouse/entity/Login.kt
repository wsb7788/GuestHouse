package com.guesthouse.entity

data class Login(
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
