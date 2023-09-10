package com.products.app.domain.usecase.base

// IN -> params type
// OUT -> returned type
interface BaseUsecase<OUT, IN> {
    suspend fun invoke(params: IN): OUT
}