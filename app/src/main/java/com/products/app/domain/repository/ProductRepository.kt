package com.products.app.domain.repository

import com.products.app.domain.model.GetProductRequest
import com.products.app.domain.model.Product
import com.products.app.domain.model.SearchProductsRequest

interface ProductRepository {
    suspend fun searchProducts(request: SearchProductsRequest): List<Product>
    suspend fun getProduct(request: GetProductRequest): Product
}