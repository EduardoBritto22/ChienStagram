package com.exalt.data.extensions

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class FormatToBirthdayDateTest {

    @Test
    fun `Given a correct Date string, When call the format function, Then return the date in the correct birthday format` () = runTest {
        //Given
        val rawDateString = "1958-08-20T23:52:42.504Z"
        val expectedDateString = "20/08/1958"

        //When
        val actualBirthdayDate = rawDateString.formatToBirthdayDate()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }


    @Test
    fun `Given a wrong Date string, When call the format function, Then return an empty string`() = runTest {
        //Given
        val rawDateString = ""
        val expectedDateString = ""

        //When
        val actualBirthdayDate = rawDateString.formatToBirthdayDate()

        //Then
        assertEquals(expectedDateString,actualBirthdayDate)
    }


}