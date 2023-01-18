package com.exalt.data.extensions

import io.mockk.every
import io.mockk.mockkStatic
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.joda.time.LocalDateTime
import org.junit.Before
import org.junit.Test

private const val utcTimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

class FormatToDurationTest {
    @Before
    fun setUp(){
        //Set a static date time to 18/01/2022 0h0
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() } returns LocalDateTime(2022,1,18,0,0)
    }

    @Test
    fun `Given a 21 weeks old start date, When call the format function, Then return the correct duration in weeks` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().minusWeeks(21).toString(utcTimeFormat)
        val expectedDateString = "21 sem"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a 2 days old start date, When call the format function, Then return the correct duration in days` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().minusDays(2).toString(utcTimeFormat)//"2022-01-16T00:00:00.000Z" // 16/01/2022 0h00
        val expectedDateString = "2 j"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a 3 years old start date, When call the format function, Then return the correct duration in years` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().minusYears(3).toString(utcTimeFormat) //"2019-01-18T00:00:00.000Z" // 18/01/2019 0h00
        val expectedDateString = "3 a"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }


    @Test
    fun `Given a 5 hours old start date, When call the format function, Then return the correct duration in hours` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().minusHours(5).toString(utcTimeFormat)//"2022-01-17T19:00:00.000Z" // 17/01/2022 19h00
        val expectedDateString = "5 h"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }



    @Test
    fun `Given a 4 minutes old start date, When call the format function, Then return the correct duration in minutes` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().minusMinutes(4).toString(utcTimeFormat)//"2022-01-17T23:56:00.000Z" // 17/01/2022 23h56
        val expectedDateString = "4 min"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }


    @Test
    fun `Given a few seconds old start date, When call the format function, Then return the duration as Now` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().minusSeconds(15).toString(utcTimeFormat)//"2022-01-17T23:59:45.000Z" // 17/01/2022 23h56
        val expectedDateString = "now"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a few seconds old start date with a non UTC format, When call the format function, Then return the duration as Now` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().minusSeconds(15).toString("yyyy-MM-dd'T'HH:mm:ss") //"2022-01-17T23:59:45" // 17/01/2022 23h56
        val expectedDateString = "now"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a start date after the end date, When call the format function, Then return an empty string` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().plusYears(1).toString(utcTimeFormat)
        val expectedDateString = ""

        //When
        val actualBirthdayDate = rawDateString.formatToDuration()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given an invalid start date, When call the format function, Then return an empty string` () = runTest {

        //Given
        val rawDateString = "test" // ----
        val expectedDateString = ""

        //When
        val actualBirthdayDate = rawDateString.formatToDuration()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }



}