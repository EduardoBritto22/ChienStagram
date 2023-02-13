package com.exalt.core.data.mappers

import com.exalt.api.models.CommentDTO
import com.exalt.core.data.extensions.convertToDuration
import com.exalt.core.domain.home.models.CommentModel
import javax.inject.Inject

class CommentMapper @Inject constructor(
    private val ownerPreviewMapper: OwnerPreviewMapper,
) {

    fun fromListDto(comments: List<CommentDTO>): List<CommentModel> =
        comments.map { fromDto(it) }

    private fun fromDto(comment: CommentDTO) = CommentModel(
        id = comment.id,
        post = comment.post,
        durationFromPublishDate = comment.publishDate.convertToDuration(),
        message = comment.message,
        owner = ownerPreviewMapper.fromDto(comment.owner)
    )
}