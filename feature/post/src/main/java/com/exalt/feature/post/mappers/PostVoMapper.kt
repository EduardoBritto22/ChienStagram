package com.exalt.feature.post.mappers

import android.content.res.Resources
import com.exalt.core.ui.extensions.formatToLocalMediumDateTimeString
import com.exalt.core.data.extensions.getLocale
import com.exalt.core.domain.home.models.PostModel
import com.exalt.feature.post.viewobjects.PostVO
import javax.inject.Inject

class PostVoMapper @Inject constructor(
    private val resources: Resources
) {

    fun toPostVO(postModel: PostModel?): PostVO? {

        postModel?.let {
            val locale = resources.getLocale()

            return PostVO(
                id = postModel.id,
                text = postModel.text,
                publishDate = postModel.publishDate.formatToLocalMediumDateTimeString(locale),
                ownerId = postModel.owner.id,
                ownerName = postModel.owner.name,
                ownerPictureUri = postModel.owner.pictureUrl,
                imageUri = postModel.imageUrl,
                tags = postModel.tags,
                likes = postModel.likes
            )
        }

        return null
    }
}