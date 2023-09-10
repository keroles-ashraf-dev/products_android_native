package com.products.app.domain.usecase.auth

import com.products.app.domain.model.LoginRequest
import com.products.app.domain.model.User
import com.products.app.domain.repository.AuthRepository
import com.products.app.domain.usecase.base.BaseUsecase
import javax.inject.Inject

class LoginUsecase @Inject constructor(
    private val authRepository: AuthRepository
) : BaseUsecase<User, LoginRequest> {
    override suspend operator fun invoke(params: LoginRequest) = authRepository.login(params)
}