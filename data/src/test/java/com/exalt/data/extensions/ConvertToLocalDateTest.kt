package com.exalt.data.extensions

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.test.runTest
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.junit.Test

class ConvertToLocalDateTest {

    @Test
    fun `Given a correct Date string, When call the format function, Then return the date in the correct birthday format` () = runTest {
        //Given
        val rawDateString = "1958-08-20T23:52:42.504Z"
        val expectedDate = DateTime(rawDateString, DateTimeZone.UTC).toLocalDate()

        //When
        val actualBirthdayDate = rawDateString.convertToLocalDate()

        //Then
        assertEquals(expectedDate,actualBirthdayDate)
    }


    @Test
    fun `Given a wrong Date string, When call the format function, Then return null`() = runTest {
        //Given
        val rawDateString = ""

        //When
        val actualBirthdayDate = rawDateString.convertToLocalDate()

        //Then
        assertNull(actualBirthdayDate)
    }


}