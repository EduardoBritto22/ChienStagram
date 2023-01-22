package com.exalt.feature.home.viewobjects

data class PostPreviewVO (
    val id: String,
    val text: String,
    val imageUri: String,
    val publishDate: String,
    val ownerId: String,
    val ownerName: String,
    val ownerPictureUri: String
)