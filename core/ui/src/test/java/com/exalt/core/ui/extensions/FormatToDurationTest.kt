package com.exalt.core.ui.extensions

import android.content.res.Resources
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.joda.time.DateTimeZone
import org.joda.time.Duration
import org.joda.time.LocalDateTime
import org.junit.Before
import org.junit.Test

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

        val endDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC)
        val startDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC).minusWeeks(weeks.toInt())
        
        //Given
        val rawDuration = Duration(startDate,endDate)
        val expectedDateString = "$weeks sem"

        //When
        val actualBirthdayDate = rawDuration.formatToDuration(resources)

        //Then
        TestCase.assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a 2 days old start date, When call the format function, Then return the correct duration in days` () = runTest {

        val days: Long = 2
        every {
            resources.getString(any(),eq(days))
        } returns "$days j"

        val endDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC)
        val startDate = LocalDateTime.now().minusDays(days.toInt()).toDateTime(DateTimeZone.UTC)

        //Given
        val rawDuration = Duration(startDate,endDate)
        val expectedDateString = "$days j"

        //When
        val actualBirthdayDate = rawDuration.formatToDuration(resources)

        //Then
        TestCase.assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a 3 years old start date, When call the format function, Then return the correct duration in years` () = runTest {

        val years: Long = 3
        every {
            resources.getString(any(),eq(years))
        } returns "$years a"

        val endDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC)
        val startDate = LocalDateTime.now().minusYears(years.toInt()).toDateTime(DateTimeZone.UTC)

        //Given
        val rawDuration = Duration(startDate,endDate)
        val expectedDateString = "$years a"

        //When
        val actualBirthdayDate = rawDuration.formatToDuration(resources)

        //Then
        TestCase.assertEquals(expectedDateString,actualBirthdayDate)
    }


    @Test
    fun `Given a 5 hours old start date, When call the format function, Then return the correct duration in hours` () = runTest {

        val hours: Long = 5
        every {
            resources.getString(any(),eq(hours))
        } returns "$hours h"

        val endDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC)
        val startDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC).minusHours(hours.toInt())

        //Given
        val rawDuration = Duration(startDate,endDate)
        val expectedDateString = "$hours h"

        //When
        val actualBirthdayDate = rawDuration.formatToDuration(resources)

        //Then
        TestCase.assertEquals(expectedDateString,actualBirthdayDate)
    }



    @Test
    fun `Given a 4 minutes old start date, When call the format function, Then return the correct duration in minutes` () = runTest {

        val minutes: Long = 4
        every {
            resources.getString(any(),eq(minutes))
        } returns "$minutes min"

        val endDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC)
        val startDate = LocalDateTime.now().minusMinutes(minutes.toInt()).toDateTime(DateTimeZone.UTC)

        //Given
        val rawDuration = Duration(startDate,endDate)
        val expectedDateString = "$minutes min"

        //When
        val actualBirthdayDate = rawDuration.formatToDuration(resources)

        //Then
        TestCase.assertEquals(expectedDateString,actualBirthdayDate)
    }


    @Test
    fun `Given a few seconds old start date, When call the format function, Then return the duration as Now` () = runTest {

        every {
            resources.getString(any())
        } returns "now"

        val endDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC)
        val startDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC).minusSeconds(15)

        //Given
        val rawDuration = Duration(startDate,endDate)
        val expectedDateString = "now"

        //When
        val actualBirthdayDate = rawDuration.formatToDuration(resources)

        //Then
        TestCase.assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a few seconds old start date with a non UTC format, When call the format function, Then return the duration as Now` () = runTest {

        every {
            resources.getString(any())
        } returns "now"

        val endDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC)
        val startDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC).minusSeconds(15)

        //Given
        val rawDuration = Duration(startDate,endDate)
        val expectedDateString = "now"

        //When
        val actualBirthdayDate = rawDuration.formatToDuration(resources)

        //Then
        TestCase.assertEquals(expectedDateString,actualBirthdayDate)
    }

    @Test
    fun `Given a start date after the end date, When call the format function, Then return an empty string` () = runTest {

        val endDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC)
        val startDate = LocalDateTime.now().toDateTime(DateTimeZone.UTC).plusYears(1)

        //Given
        val rawDuration = Duration(startDate,endDate)
        val expectedDateString = ""

        //When
        val actualDuration = rawDuration.formatToDuration(resources)

        //Then
        TestCase.assertEquals(expectedDateString,actualDuration)
    }

}