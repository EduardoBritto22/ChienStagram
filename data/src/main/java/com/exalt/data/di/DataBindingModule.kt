package com.exalt.data.di

import com.exalt.data.repositories.CommentRepositoryImpl
import com.exalt.data.repositories.OwnerRepositoryImpl
import com.exalt.data.repositories.PostRepositoryImpl
import com.exalt.domain.home.repositories.CommentRepository
import com.exalt.domain.home.repositories.OwnerRepository
import com.exalt.domain.home.repositories.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBindingModule {

    @Binds
    internal abstract fun bindPostRepository(impl: PostRepositoryImpl): PostRepository

    @Binds
    internal abstract fun bindOwnerRepository(impl: OwnerRepositoryImpl): OwnerRepository

    @Binds
    internal abstract fun bindCommentRepository(impl: CommentRepositoryImpl): CommentRepository
}