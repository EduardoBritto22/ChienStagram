package com.exalt.feature.home.mappers

import android.content.res.Resources
import com.exalt.data.extensions.formatToPostDate
import com.exalt.data.extensions.getLocale
import com.exalt.domain.home.models.PostPreviewModel
import com.exalt.feature.home.viewobjects.PostVO
import javax.inject.Inject

class PostPreviewMapper @Inject constructor(
    private val resources: Resources
) {
    fun toListPostVO(postPreviewModels: List<PostPreviewModel>) =
        postPreviewModels.map { toPostVO(it) }

    private fun toPostVO(postPreviewModel: PostPreviewModel): PostVO {

        val locale = resources.getLocale()

       return PostVO(
            id = postPreviewModel.id,
            text = postPreviewModel.text,
            imageUri = postPreviewModel.imageUrl,
            publishDate = postPreviewModel.publishDate.formatToPostDate(locale),
            ownerId = postPreviewModel.owner.id,
            ownerName = postPreviewModel.owner.name,
            ownerPictureUri = postPreviewModel.owner.pictureUrl
        )
    }
}