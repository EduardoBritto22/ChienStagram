package com.exalt.data.di

import com.exalt.data.repositories.OwnerRepositoryImpl
import com.exalt.domain.home.repositories.OwnerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class OwnerRepositoryModule {

    @Binds
    internal abstract fun bindOwnerRepository(impl: OwnerRepositoryImpl): OwnerRepository
}