package com.exalt.core.data.mappers

import com.exalt.api.models.PostDTO
import com.exalt.core.data.extensions.convertToDateTime
import com.exalt.core.domain.home.models.PostModel
import javax.inject.Inject

class PostMapper @Inject constructor(
    private val ownerPreviewMapper: OwnerPreviewMapper
) {
    fun fromDto(post: PostDTO): PostModel {
        return PostModel(
            id = post.id,
            text = post.text,
            imageUrl = post.image,
            publishDate = post.publishDate.convertToDateTime(),
            owner = ownerPreviewMapper.fromDto(post.owner),
            tags = post.tags,
            link = post.link.orEmpty(),
            likes = post.likes
        )
    }
}