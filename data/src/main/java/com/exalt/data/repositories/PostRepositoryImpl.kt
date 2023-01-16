package com.exalt.data.repositories

import com.exalt.api.services.PostService
import com.exalt.data.mappers.PostPreviewMapper
import com.exalt.domain.home.models.PostModel
import com.exalt.domain.home.models.PostPreviewModel
import com.exalt.domain.home.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class PostRepositoryImpl @Inject constructor(
    private val postService: PostService,
    private val postPreviewMapper: PostPreviewMapper,
) : PostRepository {
    override suspend fun getPosts(page: UInt): List<PostPreviewModel> =
        postService.getPosts(page).let { response ->
            if (response.isSuccessful) {
                postPreviewMapper.fromListDto(response.body()!!.data)
            } else {
                emptyList()
            }
        }

    override suspend fun getPostBy(id: String): PostModel {
        TODO("Not yet implemented")
    }
}