package com.products.app.core.error

object ErrorHandler {

    fun handle(e: Exception): String {
        return when (e) {
            is ServerException -> e.message.toString()
            is CacheException -> e.message.toString()
            is LocalException -> e.message.toString()
            else -> e.message.toString()
        }
    }

}
