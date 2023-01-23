package com.exalt.core.domain.home.usecases

import com.exalt.core.domain.home.models.CommentModel
import com.exalt.core.domain.home.repositories.CommentRepository
import javax.inject.Inject

class GetCommentsByPostUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {
    suspend fun invoke(id: String, page: UInt): List<CommentModel> = runCatching {
        commentRepository.getCommentsByPost(id, page)
    }.getOrDefault(emptyList())
}