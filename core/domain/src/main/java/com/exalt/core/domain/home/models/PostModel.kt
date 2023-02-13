package com.exalt.core.domain.home.models

import org.joda.time.DateTime

data class PostModel(
    val id: String,
    val text: String,
    val imageUrl: String,
    val likes: Int = 0,
    val link: String,
    val tags: List<String>,
    val publishDate: DateTime,
    val owner: OwnerPreviewModel
)
