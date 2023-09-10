package com.products.app.domain.repository

import com.products.app.domain.model.LoginRequest
import com.products.app.domain.model.User

interface AuthRepository {
    suspend fun login(request: LoginRequest): User
}