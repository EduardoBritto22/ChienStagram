package com.exalt.core.domain.home.repositories

import com.exalt.core.domain.home.models.CommentModel

interface CommentRepository {
    suspend fun getCommentsByPost(id: String, page: UInt): List<CommentModel>
}