package com.exalt.core.data.repositories

import com.exalt.api.services.RemoteService
import com.exalt.core.data.mappers.CommentMapper
import com.exalt.core.domain.home.models.CommentModel
import com.exalt.core.domain.home.repositories.CommentRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class CommentRepositoryImpl @Inject constructor(
    private val remoteService: RemoteService,
    private val commentMapper: CommentMapper
) : CommentRepository {

    override suspend fun getCommentsByPost(id: String, page: UInt): List<CommentModel> =
        remoteService.getCommentsByPost(id, page).let { response ->
            if (response.isSuccessful) {
                commentMapper.fromListDto(response.body()!!.data)
            } else {
                emptyList()
            }
        }

}