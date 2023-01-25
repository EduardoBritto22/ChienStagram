package com.exalt.core.ui.extensions

import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.junit.Test
import java.util.*

class FormatToLocalMediumDateTimeTest {

    @Test
    fun `Given a datetime and locale as France, When call the format function, Then return the correct formatted datetime in french` () = runTest {

        //Given
        val rawDateTime = DateTime("2020-08-20T23:52:42.504Z", DateTimeZone.UTC)
        val expectedDateString = "20 août 2020 à 23:52:42"

        //When
        val actualFormattedDate = rawDateTime.formatToLocalMediumDateTimeString(Locale.FRANCE)

        //Then
        TestCase.assertEquals(expectedDateString,actualFormattedDate)
    }

    @Test
    fun `Given a datetime and locale as US, When call the format function, Then return the correct formatted datetime in english` () = runTest {

        //Given
        val rawDateTime = DateTime("2020-08-20T23:52:42.504Z", DateTimeZone.UTC)
        val expectedDateString = "Aug 20, 2020, 11:52:42 PM"

        //When
        val actualFormattedDate = rawDateTime.formatToLocalMediumDateTimeString(Locale.US)

        //Then
        TestCase.assertEquals(expectedDateString,actualFormattedDate)
    }

}