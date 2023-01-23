package com.exalt.core.domain.home.models

import org.joda.time.DateTime

data class PostPreviewModel (
    val id: String,
    val text: String,
    val imageUrl: String,
    val publishDate: DateTime,
    val owner: OwnerPreviewModel,
)
