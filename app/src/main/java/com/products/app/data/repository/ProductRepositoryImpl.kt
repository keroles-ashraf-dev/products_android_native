package com.products.app.data.repository

import com.products.app.data.mapper.toModel
import com.products.app.data.network.ApiResponseHandler
import com.products.app.data.network.ApiService
import com.products.app.domain.model.GetProductRequest
import com.products.app.domain.model.Product
import com.products.app.domain.model.SearchProductsRequest
import com.products.app.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productApi: ApiService
) : ProductRepository {

    override suspend fun searchProducts(request: SearchProductsRequest): List<Product> {
        val res = ApiResponseHandler { productApi.searchProducts(request.keyword) }
        return res.products.map { it.toModel() }
    }

    override suspend fun getProduct(request: GetProductRequest): Product {
        val res = ApiResponseHandler { productApi.getProduct(request.id) }
        return res.toModel()
    }
}