package com.exalt.api.di

import com.exalt.api.DummyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteServiceModule {
    @Provides
    fun provideRemoteService() = DummyApi().remoteService
}