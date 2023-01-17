package com.exalt.domain.home.usecases

import com.exalt.domain.home.models.DomainModelFactory.getDefaultOwnerModel
import com.exalt.domain.home.repositories.UserRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class GetOwnerUseCaseTest {
    private val userRepository: UserRepository = mockk()
    private val getOwnerUseCase = GetOwnerUseCase(userRepository)

    @Test
    fun `Given repository returns right owner, When GetOwnerUseCase is invoked with an Id, Then returns the right owner`() = runTest {

        val id = UUID.randomUUID().toString()

        // Given
        val expectedOwner =  getDefaultOwnerModel()

        coEvery { userRepository.getUserBy(id) } returns expectedOwner

        // When
        val actualOwner = getOwnerUseCase.invoke(id)

        // Then
        assertEquals(expectedOwner, actualOwner)
    }

    @Test
    fun `Given repository throws exception, When GetOwnerUseCase is invoked, Then returns null`() = runTest {
        // Given
        coEvery { userRepository.getUserBy("") } throws NullPointerException()

        // When
        val owner = getOwnerUseCase.invoke("")

        // Then
        assertNull(owner)
    }
}