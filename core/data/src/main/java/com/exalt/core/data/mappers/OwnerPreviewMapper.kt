package com.exalt.core.data.mappers

import com.exalt.api.models.UserPreviewDTO
import com.exalt.core.domain.home.models.OwnerPreviewModel
import javax.inject.Inject

class OwnerPreviewMapper @Inject constructor() {
    fun fromDto(userPreview: UserPreviewDTO) = OwnerPreviewModel(
        id = userPreview.id,
        name = "${userPreview.firstName} ${userPreview.lastName}",
        pictureUrl = userPreview.picture,
    )
}