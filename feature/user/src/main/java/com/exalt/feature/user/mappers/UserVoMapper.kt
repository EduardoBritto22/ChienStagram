package com.exalt.feature.user.mappers

import com.exalt.core.ui.extensions.formatToBirthDateString
import com.exalt.domain.home.enums.Gender
import com.exalt.domain.home.models.OwnerModel
import com.exalt.feature.user.R
import com.exalt.feature.user.viewobjects.UserVO
import javax.inject.Inject

class UserVoMapper @Inject constructor() {

    fun toUserVO(ownerModel: OwnerModel?): UserVO? {
        ownerModel?.let {
            return UserVO(
                id = ownerModel.id,
                name = ownerModel.name,
                email = ownerModel.email,
                phone = ownerModel.phone,
                genderIcon = getGenderIcon(ownerModel.gender),
                dateOfBirth = ownerModel.dateOfBirth.formatToBirthDateString(),
                address = ownerModel.address.address,
                pictureUrl = ownerModel.pictureUrl
            )
        }
        return null
    }

    private fun getGenderIcon(gender: Gender): Int =
        when(gender){
            Gender.OTHER -> R.drawable.ic_other
            Gender.MALE -> R.drawable.ic_male
            Gender.FEMALE -> R.drawable.ic_female
            else -> R.drawable.ic_other
        }



}