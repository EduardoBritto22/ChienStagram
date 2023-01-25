package com.exalt.data.extensions

import io.mockk.every
import io.mockk.mockkStatic
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.joda.time.DateTimeZone
import org.joda.time.Duration
import org.joda.time.LocalDateTime
import org.junit.Before
import org.junit.Test

private const val utcTimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

class ConvertToDurationTest {

    @Before
    fun setUp(){

        //Set a static date time to 18/01/2022 0h0
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() } returns LocalDateTime(2022,1,18,0,0)

    }

    @Test
    fun `Given a 21 weeks old start date, When call the format function, Then return the correct duration in weeks` () = runTest {
        val weeks: Long = 21

        //Given
        val minus21WeeksDate = LocalDateTime.now().minusWeeks(weeks.toInt())
        val rawDateString = minus21WeeksDate.toString(utcTimeFormat)
        val expectedDuration = Duration(minus21WeeksDate.toDateTime(DateTimeZone.UTC), LocalDateTime.now().toDateTime(DateTimeZone.UTC))

        //When
        val duration = rawDateString.convertToDuration()

        //Then
        assertEquals(expectedDuration,duration)
    }


    @Test
    fun `Given a 15 seconds old start date with a non UTC format, When call the format function, Then return the duration of 15 seconds` () = runTest {

        //Given
        val rawDateString = LocalDateTime.now().minusSeconds(15).toString("yyyy-MM-dd'T'HH:mm:ss") //"2022-01-17T23:59:45" // 17/01/2022 23h56
        val expectedDuration = Duration(15000)

        //When
        val actualDuration = rawDateString.convertToDuration()

        //Then
        assertEquals(expectedDuration,actualDuration)
    }


    @Test
    fun `Given an invalid start date, When call the format function, Then return a Duration of 0` () = runTest {

        //Given
        val rawDateString = "test" // ----
        val expectedDuration = Duration(0)

        //When
        val actualDuration = rawDateString.convertToDuration()

        //Then
        assertEquals(expectedDuration,actualDuration)
    }



}