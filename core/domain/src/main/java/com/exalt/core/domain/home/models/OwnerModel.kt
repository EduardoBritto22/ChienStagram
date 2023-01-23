package com.exalt.core.domain.home.models

import com.exalt.core.domain.home.enums.Gender
import org.joda.time.LocalDate

data class OwnerModel(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val gender: Gender,
    val dateOfBirth: LocalDate?,
    val pictureUrl: String,
    val address: LocationModel
)
