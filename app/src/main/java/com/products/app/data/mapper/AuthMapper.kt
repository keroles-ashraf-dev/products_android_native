package com.products.app.data.mapper

import com.products.app.data.dto.UserDto
import com.products.app.domain.model.User

fun UserDto.toModel(): User {
    return User(
        id = id,
        username = username,
        email = email,
        firstName = firstName,
        lastName = lastName,
        gender = gender,
        image = image,
        token = token,
    )
}