package com.exalt.data.mappers

import android.content.res.Resources
import com.exalt.api.models.PostPreviewDTO
import com.exalt.data.extensions.formatToPostDate
import com.exalt.data.extensions.getLocale
import com.exalt.domain.home.models.PostPreviewModel
import javax.inject.Inject

class PostPreviewMapper @Inject constructor(
    private val ownerPreviewMapper: OwnerPreviewMapper,
    private val resources: Resources
) {
    fun fromListDto(postPreviews: List<PostPreviewDTO>): List<PostPreviewModel> =
        postPreviews.map { fromDto(it) }

    private fun fromDto(postPreview: PostPreviewDTO): PostPreviewModel {
        val locale = resources.getLocale()

        return PostPreviewModel(
            id = postPreview.id,
            text = postPreview.text,
            imageUrl = postPreview.image,
            publishDate = postPreview.publishDate.formatToPostDate(locale),
            owner = ownerPreviewMapper.fromDto(postPreview.owner)
        )
    }
}