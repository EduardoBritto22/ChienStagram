package com.exalt.domain.home.usecases

import com.exalt.domain.home.models.PostPreviewModel
import com.exalt.domain.home.repositories.PostRepository
import javax.inject.Inject

class GetPostPreviewsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(): List<PostPreviewModel> = runCatching {
        postRepository.getPosts(0u)
    }.getOrDefault(emptyList())
}