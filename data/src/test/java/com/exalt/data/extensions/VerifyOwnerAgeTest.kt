package com.exalt.data.extensions

import com.exalt.domain.home.models.DomainModelFactory
import io.mockk.every
import io.mockk.mockkStatic
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.joda.time.DateTime
import org.joda.time.LocalDateTime
import org.junit.Before
import org.junit.Test

class VerifyOwnerAgeTest {

    @Before
    fun setUp(){
        //Set a static date time to 18/01/2022 0h0
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() } returns LocalDateTime(2022, 1, 18, 0, 0)
    }

    @Test
    fun `Given an age equals to 18, When call the format function, Then return the same picture url` () =
        runTest {
            val birthDayDate = LocalDateTime.now().minusYears(18)

            //Given
            val rawPictureUrlString = DomainModelFactory.OWNER_PICTURE_URL
            val expectedPictureUrl = DomainModelFactory.OWNER_PICTURE_URL

            //When
            val actualPictureUrl = rawPictureUrlString.verifyOwnerAge(birthDayDate.toString())

            //Then
            TestCase.assertEquals(expectedPictureUrl, actualPictureUrl)
        }

    @Test
    fun `Given an age less than 18, When call the format function, Then return an empty string` () =
        runTest {

            val birthDayDate = DateTime.now().minusYears(12)

            //Given
            val rawPictureUrlString = DomainModelFactory.OWNER_PICTURE_URL
            val expectedPictureUrl = ""

            //When
            val actualPictureUrl = rawPictureUrlString.verifyOwnerAge(birthDayDate.toString())

            //Then
            TestCase.assertEquals(expectedPictureUrl, actualPictureUrl)
        }
}