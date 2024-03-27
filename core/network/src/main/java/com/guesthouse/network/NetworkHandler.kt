package com.guesthouse.network

import android.util.Log
import com.guesthouse.network.base.ApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.Parameters
import io.ktor.http.ParametersBuilder
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.headers
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

            install(HttpRequestRetry){
                retryOnServerErrors(maxRetries = RETRY_COUNT)
                exponentialDelay()
            }

        }

    @OptIn(InternalAPI::class)
    inline fun <reified T> request(
        method: HttpMethod,
        crossinline url: URLBuilder.() -> Unit,
        noinline content: (ParametersBuilder.() -> Unit)? = null,
    ): Flow<ApiResponse<T>> = flow {
        client.use {client ->
            val request: suspend () -> HttpResponse? = {
                client.request{
                    this.method = method
                    url {
                        protocol = URLProtocol.HTTPS
                        host = BASE_URL
                        url()
                    }
                    content?.let {
                        body = FormDataContent(Parameters.build { content() })
                    }
                }.body()
            }

            request()?.let { response ->
                if(response.status.value in SUCCESS_RANGE){
                    emit(response.body())
                }else{
                    //todo 오류 처리
                    emit(response.body())
                }
            }
        }
    }

    companion object {
        private const val REQUEST_TIMEOUT = 600000L
        private const val RETRY_COUNT = 5
        private const val CONNECT_TIMEOUT = 10000L
        private const val LOG_TAG = "KTOR_LOG"
        const val BASE_URL = "http://3.25.160.226:8080/api/auth/signup"

        val SUCCESS_RANGE = 200..299
    }
}