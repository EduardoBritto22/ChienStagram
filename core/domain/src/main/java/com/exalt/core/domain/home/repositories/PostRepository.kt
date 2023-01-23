package com.exalt.core.domain.home.repositories

import com.exalt.core.domain.home.models.PostModel
import com.exalt.core.domain.home.models.PostPreviewModel

interface PostRepository {
    suspend fun getPosts(page: UInt): List<PostPreviewModel>
    suspend fun getPostBy(id: String): PostModel
}