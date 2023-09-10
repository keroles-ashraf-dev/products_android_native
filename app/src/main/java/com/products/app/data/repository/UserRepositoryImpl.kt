package com.products.app.data.repository

import com.products.app.data.mapper.toModel
import com.products.app.data.network.ApiResponseHandler
import com.products.app.data.network.ApiService
import com.products.app.domain.model.NoParams
import com.products.app.domain.model.User
import com.products.app.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    override suspend fun getUser(request: NoParams): User {
        val res = ApiResponseHandler { apiService.getUser() }
        return res.toModel()
    }
}