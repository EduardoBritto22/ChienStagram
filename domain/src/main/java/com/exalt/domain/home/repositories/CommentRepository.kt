package com.exalt.domain.home.repositories

import com.exalt.domain.home.models.CommentModel

interface CommentRepository {
    suspend fun getCommentsByPost(id: String): List<CommentModel>
}