package com.products.app.di

import com.products.app.data.repository.AuthRepositoryImpl
import com.products.app.data.repository.ProductRepositoryImpl
import com.products.app.data.repository.UserRepositoryImpl
import com.products.app.domain.repository.AuthRepository
import com.products.app.domain.repository.ProductRepository
import com.products.app.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @ViewModelScoped
    @Binds
    fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @ViewModelScoped
    @Binds
    fun bindsAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @ViewModelScoped
    @Binds
    fun bindsProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository
}