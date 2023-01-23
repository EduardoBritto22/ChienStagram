package com.exalt.data

import com.exalt.api.models.*
import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.core.domain.home.models.DomainModelFactory.COMMENT_ID
import com.exalt.core.domain.home.models.DomainModelFactory.COMMENT_MESSAGE
import com.exalt.core.domain.home.models.DomainModelFactory.COMMENT_PUBLISH_DATE
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_BIRTHDATE_RAW
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_CITY
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_COUNTRY
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_EMAIL
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_FIRST_NAME
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_GENDER_MALE
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_ID
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_LAST_NAME
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_PHONE
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_PICTURE_URL
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_REGISTER_DATE
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_STATE
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_STREET
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_TITLE
import com.exalt.core.domain.home.models.DomainModelFactory.POST_ID
import com.exalt.core.domain.home.models.DomainModelFactory.POST_LIKES
import com.exalt.core.domain.home.models.DomainModelFactory.POST_LINK_URL

object ModelDataFactory {
    fun getPostPreviewDTO(id: String = POST_ID) = PostPreviewDTO(
        id = id,
        text = DomainModelFactory.POST_TEXT,
        image = DomainModelFactory.POST_IMAGE_URL,
        likes = 23,
        tags = listOf("tag1", "tag2", "tag3"),
        publishDate = DomainModelFactory.POST_PUBLISH_DATE,
        owner = getUserPreviewDTO(),
    )

    fun getPostDTO(id: String = POST_ID) = PostDTO(
        id = id,
        text = DomainModelFactory.POST_TEXT,
        image = DomainModelFactory.POST_IMAGE_URL,
        likes = POST_LIKES,
        tags = listOf("tag1", "tag2", "tag3"),
        publishDate = DomainModelFactory.POST_PUBLISH_DATE,
        owner = getUserPreviewDTO(),
        link = POST_LINK_URL
    )

    fun getUserPreviewDTO(id: String = OWNER_ID) =
        UserPreviewDTO(
            id = id,
            title = OWNER_TITLE,
            firstName = OWNER_FIRST_NAME,
            lastName = OWNER_LAST_NAME,
            picture = OWNER_PICTURE_URL
        )

    fun getOwnerDTO(id: String = OWNER_ID) =
        UserDTO(
            id = id,
            title = OWNER_TITLE,
            firstName = OWNER_FIRST_NAME,
            lastName = OWNER_LAST_NAME,
            picture = OWNER_PICTURE_URL,
            dateOfBirth = OWNER_BIRTHDATE_RAW,
            email = OWNER_EMAIL,
            gender = OWNER_GENDER_MALE,
            phone = OWNER_PHONE,
            location = getLocationDTO(),
            registerDate = OWNER_REGISTER_DATE,
        )

    fun getLocationDTO() =
        LocationDTO(
            street = OWNER_STREET,
            city = OWNER_CITY,
            state = OWNER_STATE,
            country = OWNER_COUNTRY
        )

    fun getCommentDTO(id: String = COMMENT_ID) =
        CommentDTO(
            id = id,
            message = COMMENT_MESSAGE,
            getUserPreviewDTO(OWNER_ID),
            post = POST_ID,
            publishDate = COMMENT_PUBLISH_DATE
        )
}