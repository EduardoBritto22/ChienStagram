package com.exalt.domain.home.models

data class CommentModel(
    val id: String,
    val message: String,
    val owner: OwnerPreviewModel,
    val post: String,
    val publishDate: String
)
