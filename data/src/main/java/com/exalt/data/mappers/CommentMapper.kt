package com.exalt.data.mappers

import com.exalt.api.models.CommentDTO
import com.exalt.domain.home.models.CommentModel
import javax.inject.Inject

class CommentMapper @Inject constructor(
    private val ownerPreviewMapper: OwnerPreviewMapper
) {
    fun fromDto(comment: CommentDTO) = CommentModel(
        id = comment.id,
        post = comment.post,
        publishDate = comment.publishDate,
        message = comment.message,
        owner = ownerPreviewMapper.fromDto(comment.owner)
    )
}