package com.exalt.feature.post

import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.core.domain.home.models.DomainModelFactory.COMMENT_MESSAGE
import com.exalt.core.domain.home.models.DomainModelFactory.POST_IMAGE_URL
import com.exalt.core.domain.home.models.DomainModelFactory.POST_LIKES
import com.exalt.core.domain.home.models.DomainModelFactory.POST_TEXT
import com.exalt.feature.post.viewobjects.CommentVO
import com.exalt.feature.post.viewobjects.PostVO

object PostFeatureVOsFactory {
    fun getDefaultCommentVO(id: String = DomainModelFactory.COMMENT_ID) = CommentVO(
        id = id,
        publishDate = DomainModelFactory.COMMENT_PUBLISH_DURATION,
        ownerId = DomainModelFactory.OWNER_ID,
        ownerName = "${DomainModelFactory.OWNER_FIRST_NAME} ${DomainModelFactory.OWNER_LAST_NAME}",
        ownerPictureUri = DomainModelFactory.OWNER_PICTURE_URL,
        message = COMMENT_MESSAGE
    )

    fun getDefaultPostVO(id: String = DomainModelFactory.POST_ID) = PostVO(
        id = id,
        publishDate = DomainModelFactory.POST_PUBLISH_DATE_FORMATTED,
        ownerId = DomainModelFactory.OWNER_ID,
        ownerName = "${DomainModelFactory.OWNER_FIRST_NAME} ${DomainModelFactory.OWNER_LAST_NAME}",
        ownerPictureUri = DomainModelFactory.OWNER_PICTURE_URL,
        likes = POST_LIKES,
        text = POST_TEXT,
        imageUri = POST_IMAGE_URL,
        tags = listOf("tag1", "tag2", "tag3")
    )
}