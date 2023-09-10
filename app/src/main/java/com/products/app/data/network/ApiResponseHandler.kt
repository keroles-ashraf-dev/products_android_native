package com.products.app.data.network

import com.products.app.core.error.ServerException
import retrofit2.Response

object ApiResponseHandler {

    suspend operator fun <T> invoke(call: suspend () -> Response<T>): T {
        val res = call()

        if (res.isSuccessful) {
            val body = res.body()
            if (body != null) return body;
        }
        if (res.errorBody() != null) throw ServerException(message = res.errorBody().toString())

        throw ServerException(message = res.message())
    }
}