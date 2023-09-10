package com.products.app.domain.usecase.product

import com.products.app.domain.model.Product
import com.products.app.domain.model.SearchProductsRequest
import com.products.app.domain.repository.ProductRepository
import com.products.app.domain.usecase.base.BaseUsecase
import javax.inject.Inject

class SearchProductsUsecase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUsecase<List<Product>, SearchProductsRequest> {
    override suspend operator fun invoke(params: SearchProductsRequest) = productRepository.searchProducts(params)
}