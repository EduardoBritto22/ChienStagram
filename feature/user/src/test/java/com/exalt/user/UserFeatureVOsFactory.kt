package com.exalt.user

import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.core.domain.home.models.DomainModelFactory.OWNER_PROFILE_BACKGROUND
import com.exalt.feature.user.enums.GenderConfig
import com.exalt.feature.user.viewobjects.UserVO


object UserFeatureVOsFactory {

    fun getDefaultUserVO(
        id: String = DomainModelFactory.OWNER_ID,
        genderConfig: GenderConfig = GenderConfig.MALE
    ) = UserVO(
        id = id,
        name = "${DomainModelFactory.OWNER_FIRST_NAME} ${DomainModelFactory.OWNER_LAST_NAME}",
        pictureUrl = DomainModelFactory.OWNER_PICTURE_URL,
        address = DomainModelFactory.OWNER_ADDRESS,
        dateOfBirth = DomainModelFactory.OWNER_BIRTHDATE_FORMATTED,
        email = DomainModelFactory.OWNER_EMAIL,
        genderConfig = genderConfig,
        phone = DomainModelFactory.OWNER_PHONE,
        profileBackground = OWNER_PROFILE_BACKGROUND
    )

}