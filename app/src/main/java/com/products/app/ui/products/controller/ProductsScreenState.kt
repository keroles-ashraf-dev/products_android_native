package com.products.app.ui.products.controller

import com.products.app.core.util.RequestState
import com.products.app.domain.model.Product

data class ProductsScreenState(
    val getProductsState: RequestState = RequestState.Loading,
    val products: List<Product> = emptyList(),
    val errorMsg: String = ""
)