package com.exalt.domain.home.models

data class PostModel(
    val id: String,
    val text: String,
    val imageUrl: String,
    val likes: Int = 0,
    val link: String,
    val tags: List<String>,
    val publishDate: String,
    val owner: OwnerPreviewModel)
