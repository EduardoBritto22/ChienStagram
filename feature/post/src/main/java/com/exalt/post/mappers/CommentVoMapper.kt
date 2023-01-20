package com.exalt.post.mappers

import android.content.res.Resources
import com.exalt.core.ui.extensions.formatToDuration
import com.exalt.domain.home.models.CommentModel
import com.exalt.post.viewobjects.CommentVO
import javax.inject.Inject

class CommentVoMapper @Inject constructor(
    private val resources: Resources
) {
    fun toListCommentVO(commentModels: List<CommentModel>) =
        commentModels.map { toPostVO(it) }

    private fun toPostVO(commentModel: CommentModel): CommentVO{

        return CommentVO(
            id = commentModel.id,
            message = commentModel.message,
            publishDate = commentModel.durationFromPublishDate.formatToDuration(resources),
            ownerId = commentModel.owner.id,
            ownerName = commentModel.owner.name,
            ownerPictureUri = commentModel.owner.pictureUrl
        )
    }
}