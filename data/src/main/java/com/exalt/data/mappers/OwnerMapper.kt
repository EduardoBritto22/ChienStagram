package com.exalt.data.mappers

import com.exalt.api.models.UserDTO
import com.exalt.data.extensions.formatToBirthdayDate
import com.exalt.domain.home.models.OwnerModel
import javax.inject.Inject

class OwnerMapper @Inject constructor(
    private val locationMapper: LocationMapper
) {

    fun fromDto(user: UserDTO) = OwnerModel(
        id = user.id,
        name = "${user.firstName} ${user.lastName}",
        pictureUrl = user.picture,
        phone = user.phone,
        gender = user.gender,
        email = user.email,
        dateOfBirth = user.dateOfBirth.formatToBirthdayDate(),
        address = locationMapper.fromDto(user.location)
    )
}