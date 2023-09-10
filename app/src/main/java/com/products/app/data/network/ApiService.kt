package com.products.app.data.network

import com.products.app.data.dto.ProductDto
import com.products.app.data.dto.ProductsDto
import com.products.app.data.dto.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // user
    @GET(ApiConstant.GET_USER_URI)
    suspend fun getUser(): Response<UserDto>

    // products
    @GET(ApiConstant.SEARCH_PRODUCTS_URI)
    suspend fun searchProducts(
        @Query("q") q: String
    ): Response<ProductsDto>

    @GET(ApiConstant.GET_PRODUCT_URI)
    suspend fun getProduct(
        @Path("id") id: Int
    ): Response<ProductDto>

    // auth
    @POST(ApiConstant.LOGIN_URI)
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Response<UserDto>
}