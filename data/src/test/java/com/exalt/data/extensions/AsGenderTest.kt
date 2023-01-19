package com.exalt.data.extensions

import com.exalt.domain.home.enums.Gender
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Test

class AsGenderTest {


    @Test
    fun `Given a female gender string, When get the string as Gender Enum, Then returns FEMALE`() = runTest {

        //Given
        val rawGenderString = "female"
        val expectedGender = Gender.FEMALE

        //When
        val actualGender = rawGenderString.asGender()

        //Then
        TestCase.assertEquals(expectedGender, actualGender)
    }


    @Test
    fun `Given a male gender string, When get the string as Gender Enum, Then returns MALE`() = runTest {

        //Given
        val rawGenderString = "male"
        val expectedGender = Gender.MALE

        //When
        val actualGender = rawGenderString.asGender()

        //Then
        TestCase.assertEquals(expectedGender, actualGender)
    }



    @Test
    fun `Given an other gender string, When get the string as Gender Enum, Then returns OTHER`() = runTest {

        //Given
        val rawGenderString = "other"
        val expectedGender = Gender.OTHER

        //When
        val actualGender = rawGenderString.asGender()

        //Then
        TestCase.assertEquals(expectedGender, actualGender)
    }



    @Test
    fun `Given a null gender string, When get the string as Gender Enum, Then returns OTHER`() = runTest {

        //Given
        val rawGenderString = null
        val expectedGender = Gender.OTHER

        //When
        val actualGender = rawGenderString.asGender()

        //Then
        TestCase.assertEquals(expectedGender, actualGender)
    }

    @Test
    fun `Given a unknown gender string, When get the string as Gender Enum, Then returns OTHER`() = runTest {

        //Given
        val rawGenderString = "test"
        val expectedGender = Gender.OTHER

        //When
        val actualGender = rawGenderString.asGender()

        //Then
        TestCase.assertEquals(expectedGender, actualGender)
    }
}