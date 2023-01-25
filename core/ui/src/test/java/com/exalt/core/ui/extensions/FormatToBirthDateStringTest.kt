package com.exalt.core.ui.extensions

import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.joda.time.DateTimeZone
import org.joda.time.LocalDate
import org.junit.Test

class FormatToBirthDateStringTest {

    @Test
    fun `Given a correct Date string, When call the format function, Then return the date in the correct birthday format` () = runTest {
        //Given
        val rawDateString = LocalDate("1958-08-20", DateTimeZone.UTC)
        val expectedDateString = "20/08/1958"

        //When
        val actualBirthdayDate = rawDateString.formatToBirthDateString()

        //Then
        TestCase.assertEquals(expectedDateString,actualBirthdayDate)
    }
}