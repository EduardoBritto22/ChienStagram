package com.exalt.feature.post.viewobjects

data class CommentVO(
    val id: String,
    val message: String,
    val publishDate: String,
    val ownerId: String,
    val ownerName: String,
    val ownerPictureUri: String
)
