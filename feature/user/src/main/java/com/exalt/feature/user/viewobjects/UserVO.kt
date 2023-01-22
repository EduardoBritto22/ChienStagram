package com.exalt.feature.user.viewobjects

data class UserVO(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val genderIcon: Int,
    val dateOfBirth: String,
    val pictureUrl: String,
    val address: String
)
