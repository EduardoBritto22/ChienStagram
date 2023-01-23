package com.exalt.core.domain.home.usecases

import com.exalt.core.domain.home.models.PostModel
import com.exalt.core.domain.home.repositories.PostRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend fun invoke(id: String): PostModel? = runCatching {
        postRepository.getPostBy(id)
    }.getOrNull()
}