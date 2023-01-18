package com.exalt.data.mappers

import android.content.res.Resources
import com.exalt.api.models.CommentDTO
import com.exalt.data.extensions.formatToDuration
import com.exalt.domain.home.models.CommentModel
import javax.inject.Inject

class CommentMapper @Inject constructor(
    private val ownerPreviewMapper: OwnerPreviewMapper,
    private val resources: Resources
) {

    fun fromListDto(comments: List<CommentDTO>): List<CommentModel> =
        comments.map { fromDto(it) }

    private fun fromDto(comment: CommentDTO) = CommentModel(
        id = comment.id,
        post = comment.post,
        durationFromPublishDate = comment.publishDate.formatToDuration(resources),
        message = comment.message,
        owner = ownerPreviewMapper.fromDto(comment.owner)
    )
}