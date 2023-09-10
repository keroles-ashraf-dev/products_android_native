package com.products.app.domain.usecase.product

import com.products.app.domain.model.GetProductRequest
import com.products.app.domain.model.Product
import com.products.app.domain.repository.ProductRepository
import com.products.app.domain.usecase.base.BaseUsecase
import javax.inject.Inject

class GetProductUsecase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUsecase<Product, GetProductRequest> {
    override suspend operator fun invoke(params: GetProductRequest) = productRepository.getProduct(params)
}