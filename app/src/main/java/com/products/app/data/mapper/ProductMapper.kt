package com.products.app.data.mapper

import com.products.app.data.dto.ProductDto
import com.products.app.data.dto.ProductsDto
import com.products.app.domain.model.Product

fun ProductDto.toModel(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        brand = brand,
        category = category,
        thumbnail = thumbnail,
        images = images
    )
}

fun ProductsDto.toModel(): List<Product> {
    return this.products.map { it.toModel() }
}