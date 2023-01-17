package com.exalt.domain.home.repositories

import com.exalt.domain.home.models.PostModel
import com.exalt.domain.home.models.PostPreviewModel

interface PostRepository {
    suspend fun getPosts(page: UInt): List<PostPreviewModel>
    suspend fun getPostBy(id: String): PostModel
}