package com.exalt.feature.home.mappers

import android.content.res.Resources
import com.exalt.core.ui.extensions.formatToLocalMediumDateTimeString
import com.exalt.core.data.extensions.getLocale
import com.exalt.domain.home.models.PostPreviewModel
import com.exalt.feature.home.viewobjects.PostPreviewVO
import javax.inject.Inject

class PostPreviewMapper @Inject constructor(
    private val resources: Resources
) {
    fun toListPostVO(postPreviewModels: List<PostPreviewModel>) =
        postPreviewModels.map { toPostVO(it) }

    private fun toPostVO(postPreviewModel: PostPreviewModel): PostPreviewVO {

        val locale = resources.getLocale()

       return PostPreviewVO(
            id = postPreviewModel.id,
            text = postPreviewModel.text,
            imageUri = postPreviewModel.imageUrl,
            publishDate = postPreviewModel.publishDate.formatToLocalMediumDateTimeString(locale),
            ownerId = postPreviewModel.owner.id,
            ownerName = postPreviewModel.owner.name,
            ownerPictureUri = postPreviewModel.owner.pictureUrl
        )
    }
}