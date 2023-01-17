package com.exalt.domain.home.models

data class OwnerModel(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val gender: String,
    val Address: LocationModel,
    val dateOfBirth: String,
    val pictureUrl: String
)
