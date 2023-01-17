package com.exalt.data.di

import com.exalt.data.repositories.CommentRepositoryImpl
import com.exalt.domain.home.repositories.CommentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CommentRepositoryModule {

    @Binds
    internal abstract fun bindCommentRepository(impl: CommentRepositoryImpl): CommentRepository
}