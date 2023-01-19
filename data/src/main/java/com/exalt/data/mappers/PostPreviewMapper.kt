package com.exalt.data.mappers

import com.exalt.api.models.PostPreviewDTO
import com.exalt.data.extensions.formatToPostDate
import com.exalt.domain.home.models.PostPreviewModel
import javax.inject.Inject

class PostPreviewMapper @Inject constructor(
    private val ownerPreviewMapper: OwnerPreviewMapper
) {
    fun fromListDto(postPreviews: List<PostPreviewDTO>): List<PostPreviewModel> =
        postPreviews.map { fromDto(it) }

    private fun fromDto(postPreview: PostPreviewDTO): PostPreviewModel {

        return PostPreviewModel(
            id = postPreview.id,
            text = postPreview.text,
            imageUrl = postPreview.image,
            publishDate = postPreview.publishDate.formatToPostDate(),
            owner = ownerPreviewMapper.fromDto(postPreview.owner)
        )
    }
}