package com.products.app.domain.repository

import com.products.app.domain.model.NoParams
import com.products.app.domain.model.User

interface UserRepository {
    suspend fun getUser(request: NoParams): User
}