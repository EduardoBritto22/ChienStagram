package com.exalt.data.mappers

import android.content.res.Resources
import com.exalt.api.models.PostDTO
import com.exalt.data.extensions.formatToPostDate
import com.exalt.data.extensions.getLocale
import com.exalt.domain.home.models.PostModel
import javax.inject.Inject

class PostMapper @Inject constructor(
    private val ownerPreviewMapper: OwnerPreviewMapper,
    private val resources: Resources
) {
    fun fromDto(post: PostDTO): PostModel {

        val locale = resources.getLocale()

        return PostModel(
            id = post.id,
            text = post.text,
            imageUrl = post.image,
            publishDate = post.publishDate.formatToPostDate(locale),
            owner = ownerPreviewMapper.fromDto(post.owner),
            tags = post.tags,
            link = post.link,
            likes = post.likes
        )
    }
}