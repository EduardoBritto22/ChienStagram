package com.exalt.domain.home.usecases

import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultOwnerModel
import com.exalt.core.domain.home.models.DomainModelFactory.getMinorOwnerModel
import com.exalt.core.domain.home.repositories.OwnerRepository
import com.exalt.core.domain.home.usecases.GetOwnerUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class GetOwnerUseCaseTest {
    private val ownerRepository: OwnerRepository = mockk()
    private val getOwnerUseCase = GetOwnerUseCase(ownerRepository)

    @Test
    fun `Given repository returns right owner, When GetOwnerUseCase is invoked with an Id, Then returns the right owner`() = runTest {

        val id = UUID.randomUUID().toString()

        // Given
        val expectedOwner =  getDefaultOwnerModel()

        coEvery { ownerRepository.getUserBy(id) } returns expectedOwner

        // When
        val actualOwner = getOwnerUseCase.invoke(id)

        // Then
        assertEquals(expectedOwner, actualOwner)
    }

    @Test
    fun `Given repository throws exception, When GetOwnerUseCase is invoked, Then returns null`() = runTest {
        // Given
        coEvery { ownerRepository.getUserBy("") } throws NullPointerException()

        // When
        val owner = getOwnerUseCase.invoke("")

        // Then
        assertNull(owner)
    }

    @Test
    fun `Given repository returns right owner minor of 18, When GetOwnerUseCase is invoked, Then returns an Owner with the picture masked`() = runTest {
        val id = UUID.randomUUID().toString()

        // Given
        val expectedOwnerPicture = ""
        val expectedOwner = getMinorOwnerModel(id)

        coEvery { ownerRepository.getUserBy(id) } returns expectedOwner

        // When
        val actualOwner = getOwnerUseCase.invoke(id)

        // Then
        assertEquals(expectedOwnerPicture, actualOwner?.pictureUrl)
    }
}