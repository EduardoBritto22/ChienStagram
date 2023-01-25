package com.exalt.domain.home.extensions

import io.mockk.every
import io.mockk.mockkStatic
import junit.framework.TestCase.assertEquals
import org.joda.time.DateTimeZone
import org.joda.time.LocalDate
import org.joda.time.LocalDateTime
import org.junit.Before
import org.junit.Test

class GetAgeInYearsTest {

    @Before
    fun setUp(){
        //Set a static date time to 18/01/2023 0h0
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() } returns LocalDateTime(2023, 1, 18, 0, 0)
    }

    @Test
    fun `Given an age equals to 18, When call the the Get function, Then return 18` (){
            //Given
            val expectedAgeInYears = 18
            val birthDayDate = LocalDate.now(DateTimeZone.UTC).minusYears(expectedAgeInYears)

            //When
            val actualAgeInYears = birthDayDate.getAgeInYears()

            //Then
            assertEquals(expectedAgeInYears, actualAgeInYears)
        }

    @Test
    fun `Given a birthday date null, When call the format function, Then return 0` () {

            //Given
            val birthDayDate: LocalDate? = null
            val expectedAgeInYears = 0

            //When
            val actualAgeInYears = birthDayDate.getAgeInYears()

            //Then
            assertEquals(expectedAgeInYears, actualAgeInYears)
        }
    @Test
    fun `Given a birthday date in the future, When call the format function, Then return 0` () {

            //Given
            val birthDayDate = LocalDate.now(DateTimeZone.UTC).plusYears(5)
            val expectedAgeInYears = 0

            //When
            val actualAgeInYears = birthDayDate.getAgeInYears()

            //Then
            assertEquals(expectedAgeInYears, actualAgeInYears)
        }
}