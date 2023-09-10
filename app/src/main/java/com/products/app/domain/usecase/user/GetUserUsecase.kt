package com.products.app.domain.usecase.user

import com.products.app.domain.model.NoParams
import com.products.app.domain.model.User
import com.products.app.domain.repository.UserRepository
import com.products.app.domain.usecase.base.BaseUsecase
import javax.inject.Inject

class GetUserUsecase @Inject constructor(
    private val userRepository: UserRepository
) : BaseUsecase<User, NoParams> {
    override suspend operator fun invoke(params: NoParams) = userRepository.getUser(params)
}