package com.products.app.data.repository

import com.products.app.data.mapper.toModel
import com.products.app.data.network.ApiResponseHandler
import com.products.app.data.network.ApiService
import com.products.app.domain.model.LoginRequest
import com.products.app.domain.model.User
import com.products.app.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AuthRepository {

    override suspend fun login(request: LoginRequest): User {
        val res = ApiResponseHandler { apiService.login(request.username, request.password) }
        return res.toModel()
    }
}