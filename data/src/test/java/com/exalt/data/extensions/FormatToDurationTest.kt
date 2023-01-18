package com.exalt.data.extensions

import android.content.res.Resources
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.joda.time.LocalDateTime
import org.junit.Before
import org.junit.Test

private const val utcTimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

class FormatToDurationTest {
    @MockK
    private lateinit var resources: Resources

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        //Set a static date time to 18/01/2022 0h0
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() } returns LocalDateTime(2022,1,18,0,0)

    }

    @Test
    fun `Given a 21 weeks old start date, When call the format function, Then return the correct duration in weeks` () = runTest {
        val weeks: Long = 21
        every {
            resources.getString(any(),eq(weeks))
        } returns "$weeks sem"

        //Given
        val rawDateString = LocalDateTime.now().minusWeeks(weeks.toInt()).toString(utcTimeFormat)
        val expectedDateString = "$weeks sem"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration(resources)

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a 2 days old start date, When call the format function, Then return the correct duration in days` () = runTest {

        val days: Long = 2
        every {
            resources.getString(any(),eq(days))
        } returns "$days j"

        //Given
        val rawDateString = LocalDateTime.now().minusDays(days.toInt()).toString(utcTimeFormat)
        val expectedDateString = "$days j"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration(resources)

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a 3 years old start date, When call the format function, Then return the correct duration in years` () = runTest {

        val years: Long = 3
        every {
            resources.getString(any(),eq(years))
        } returns "$years a"

        //Given
        val rawDateString = LocalDateTime.now().minusYears(years.toInt()).toString(utcTimeFormat)
        val expectedDateString = "$years a"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration(resources)

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }


    @Test
    fun `Given a 5 hours old start date, When call the format function, Then return the correct duration in hours` () = runTest {

        val hours: Long = 5
        every {
            resources.getString(any(),eq(hours))
        } returns "$hours h"

        //Given
        val rawDateString = LocalDateTime.now().minusHours(hours.toInt()).toString(utcTimeFormat)
        val expectedDateString = "$hours h"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration(resources)

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }



    @Test
    fun `Given a 4 minutes old start date, When call the format function, Then return the correct duration in minutes` () = runTest {

        val minutes: Long = 4
        every {
            resources.getString(any(),eq(minutes))
        } returns "$minutes min"

        //Given
        val rawDateString = LocalDateTime.now().minusMinutes(minutes.toInt()).toString(utcTimeFormat)
        val expectedDateString = "$minutes min"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration(resources)

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }


    @Test
    fun `Given a few seconds old start date, When call the format function, Then return the duration as Now` () = runTest {

        every {
            resources.getString(any())
        } returns "now"

        //Given
        val rawDateString = LocalDateTime.now().minusSeconds(15).toString(utcTimeFormat)
        val expectedDateString = "now"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration(resources)

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a few seconds old start date with a non UTC format, When call the format function, Then return the duration as Now` () = runTest {

        every {
            resources.getString(any())
        } returns "now"

        //Given
        val rawDateString = LocalDateTime.now().minusSeconds(15).toString("yyyy-MM-dd'T'HH:mm:ss") //"2022-01-17T23:59:45" // 17/01/2022 23h56
        val expectedDateString = "now"

        //When
        val actualBirthdayDate = rawDateString.formatToDuration(resources)

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a start date after the end date, When call the format function, Then return an empty string` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().plusYears(1).toString(utcTimeFormat)
        val expectedDateString = ""

        //When
        val actualBirthdayDate = rawDateString.formatToDuration(resources)

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given an invalid start date, When call the format function, Then return an empty string` () = runTest {

        //Given
        val rawDateString = "test" // ----
        val expectedDateString = ""

        //When
        val actualBirthdayDate = rawDateString.formatToDuration(resources)

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }



}