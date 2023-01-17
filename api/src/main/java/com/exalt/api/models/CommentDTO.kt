package com.exalt.api.models

data class CommentDTO(
    val id: String,
    val message: String,
    val owner: UserPreviewDTO,
    val post: String,
    val publishDate: String
)
