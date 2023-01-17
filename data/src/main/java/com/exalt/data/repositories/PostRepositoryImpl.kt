package com.exalt.data.repositories

import com.exalt.api.services.RemoteService
import com.exalt.data.exceptions.PostNotFoundException
import com.exalt.data.mappers.PostMapper
import com.exalt.data.mappers.PostPreviewMapper
import com.exalt.domain.home.models.PostModel
import com.exalt.domain.home.models.PostPreviewModel
import com.exalt.domain.home.repositories.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class PostRepositoryImpl @Inject constructor(
    private val remoteService: RemoteService,
    private val postPreviewMapper: PostPreviewMapper,
    private val postMapper: PostMapper,
) : PostRepository {
    override suspend fun getPosts(page: UInt): List<PostPreviewModel> =
        remoteService.getPosts(page).let { response ->
            if (response.isSuccessful) {
                postPreviewMapper.fromListDto(response.body()!!.data)
            } else {
                emptyList()
            }
        }

    override suspend fun getPostBy(id: String): PostModel =
        remoteService.getPostById(id).let { response ->
            if(response.isSuccessful){
                postMapper.fromDto(response.body()!!)
            }else{
                throw PostNotFoundException(response.errorBody()?.string())
            }
        }

}