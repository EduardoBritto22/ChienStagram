package com.exalt.user.mappers

import com.exalt.core.domain.home.enums.Gender
import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.feature.user.enums.GenderConfig
import com.exalt.feature.user.mappers.UserVoMapper
import com.exalt.user.UserFeatureVOsFactory.getDefaultUserVO
import org.junit.Assert
import org.junit.Test
import java.util.*

class UserVoMapperTest {
    private var userVoMapper : UserVoMapper = UserVoMapper()

    @Test
    fun `Given a male Owner Model, when mapper is called, Then returns a male UserVO`() {
        // Given
        val randomUuid = UUID.randomUUID().toString()

        // When
        val actualUserVO = userVoMapper.toUserVO(
            DomainModelFactory.getDefaultOwnerModel(
                randomUuid
            )
        )
        val expectedUserVO = getDefaultUserVO(randomUuid)

        // Then
        Assert.assertEquals(expectedUserVO, actualUserVO)
    }

    @Test
    fun `Given a female Owner Model, when mapper is called, Then returns a female UserVO`() {
        // Given
        val randomUuid = UUID.randomUUID().toString()

        // When
        val actualUserVO = userVoMapper.toUserVO(
            DomainModelFactory.getDefaultOwnerModel(
                randomUuid,
                Gender.FEMALE
            )
        )
        val expectedUserVO = getDefaultUserVO(randomUuid, GenderConfig.FEMALE)

        // Then
        Assert.assertEquals(expectedUserVO, actualUserVO)
    }

    @Test
    fun `Given a other Owner Model, when mapper is called, Then returns a other UserVO`() {
        // Given
        val randomUuid = UUID.randomUUID().toString()

        // When
        val actualUserVO = userVoMapper.toUserVO(
            DomainModelFactory.getDefaultOwnerModel(
                randomUuid,
                Gender.OTHER
            )
        )
        val expectedUserVO = getDefaultUserVO(randomUuid, GenderConfig.OTHER)

        // Then
        Assert.assertEquals(expectedUserVO, actualUserVO)
    }

    @Test
    fun `Given a null Owner Model, when mapper is called, Then returns null`() {
        // Given
        val postModel = null

        // When
        val actualPostVO = userVoMapper.toUserVO(postModel)


        // Then
        Assert.assertNull(actualPostVO)
    }

}