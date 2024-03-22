package com.guesthouse.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Inject

class NetworkHandler @Inject constructor() {

    val client: HttpClient
        get() = HttpClient(CIO) {

            install(ContentNegotiation){
                json( Json {
                    prettyPrint = true
                })
            }

            install(Logging){
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d(LOG_TAG, message)
                    }

                }
            }

            install(HttpTimeout){
                requestTimeoutMillis = REQUEST_TIMEOUT
                connectTimeoutMillis = CONNECT_TIMEOUT
            }

        }

    companion object {
        private const val REQUEST_TIMEOUT = 600000L
        private const val CONNECT_TIMEOUT = 10000L
        private const val LOG_TAG = "KTOR_LOG"
    }
}