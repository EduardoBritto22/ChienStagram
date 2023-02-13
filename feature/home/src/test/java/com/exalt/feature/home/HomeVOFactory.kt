package com.exalt.feature.home

import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_FIRST_NAME
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_ID
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_LAST_NAME
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_PICTURE_URL
import com.exalt.core.domain.home.models.DomainModelFactory.POST_ID
import com.exalt.core.domain.home.models.DomainModelFactory.POST_IMAGE_URL
import com.exalt.core.domain.home.models.DomainModelFactory.POST_PUBLISH_DATE_FORMATTED
import com.exalt.core.domain.home.models.DomainModelFactory.POST_TEXT
import com.exalt.feature.home.viewobjects.PostPreviewVO

object HomeVOFactory {
    fun getDefaultPostVO(id: String = POST_ID) = PostPreviewVO(
        id = id,
        text = POST_TEXT,
        imageUri = POST_IMAGE_URL,
        publishDate = POST_PUBLISH_DATE_FORMATTED,
        ownerId = OWNER_ID,
        ownerName = "$OWNER_FIRST_NAME $OWNER_LAST_NAME",
        ownerPictureUri = OWNER_PICTURE_URL,
    )
}