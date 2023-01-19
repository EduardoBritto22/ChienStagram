package com.exalt.data.mappers

import com.exalt.api.models.UserDTO
import com.exalt.data.extensions.asGender
import com.exalt.data.extensions.formatToBirthdayDate
import com.exalt.data.extensions.verifyOwnerAge
import com.exalt.domain.home.models.OwnerModel
import javax.inject.Inject

class OwnerMapper @Inject constructor(
    private val locationMapper: LocationMapper
) {

    fun fromDto(user: UserDTO) = OwnerModel(
        id = user.id,
        name = "${user.firstName} ${user.lastName}",
        pictureUrl = user.picture.verifyOwnerAge(user.dateOfBirth),
        phone = user.phone,
        gender = user.gender.asGender(),
        email = user.email,
        dateOfBirth = user.dateOfBirth.formatToBirthdayDate(),
        address = locationMapper.fromDto(user.location)
    )
}