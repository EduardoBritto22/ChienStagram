package com.exalt.feature.user.mappers

import com.exalt.core.ui.extensions.formatToBirthDateString
import com.exalt.core.domain.home.enums.Gender
import com.exalt.core.domain.home.models.OwnerModel
import com.exalt.feature.user.enums.GenderConfig
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
                genderConfig = getGenderIcon(ownerModel.gender),
                dateOfBirth = ownerModel.dateOfBirth.formatToBirthDateString(),
                address = ownerModel.address.address,
                pictureUrl = ownerModel.pictureUrl,
                profileBackground = "https://as1.ftcdn.net/v2/jpg/04/14/17/88/1000_F_414178875_7GqEVTasELylv9Y7vNxPjDaMCJlAToMR.jpg"
            )
        }
        return null
    }

    private fun getGenderIcon(gender: Gender): GenderConfig =
        when(gender){
            Gender.OTHER -> GenderConfig.OTHER
            Gender.MALE -> GenderConfig.MALE
            Gender.FEMALE ->GenderConfig.FEMALE
            else -> GenderConfig.OTHER
        }



}