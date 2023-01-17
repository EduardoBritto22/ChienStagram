package com.exalt.data.mappers

import com.exalt.api.models.PostDTO
import com.exalt.domain.home.models.PostModel
import javax.inject.Inject

class PostMapper @Inject constructor(
    private val ownerPreviewMapper: OwnerPreviewMapper,
) {
    fun fromDto(post: PostDTO) = PostModel(
        id = post.id,
        text = post.text,
        imageUrl = post.image,
        publishDate = post.publishDate,
        owner = ownerPreviewMapper.fromDto(post.owner),
        tags = post.tags,
        link = post.link,
        likes = post.likes
    )
}