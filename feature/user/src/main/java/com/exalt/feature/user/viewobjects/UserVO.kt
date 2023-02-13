package com.exalt.feature.user.viewobjects

import com.exalt.feature.user.enums.GenderConfig

data class UserVO(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val genderConfig: GenderConfig,
    val dateOfBirth: String,
    val pictureUrl: String,
    val address: String,
    val profileBackground: String
)
