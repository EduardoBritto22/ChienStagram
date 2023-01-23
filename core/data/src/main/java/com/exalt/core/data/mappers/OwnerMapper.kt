package com.exalt.core.data.mappers

import com.exalt.api.models.UserDTO
import com.exalt.core.data.extensions.convertToLocalDate
import com.exalt.domain.home.enums.Gender
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
        gender = getGender(user.gender),
        email = user.email,
        dateOfBirth = user.dateOfBirth.convertToLocalDate(),
        address = locationMapper.fromDto(user.location)
    )

   private fun getGender(genderString: String?) = when (genderString) {
        null -> Gender.OTHER
        else -> Gender.values()
            .firstOrNull { gender -> gender.text == genderString }
            ?: Gender.OTHER
    }
}