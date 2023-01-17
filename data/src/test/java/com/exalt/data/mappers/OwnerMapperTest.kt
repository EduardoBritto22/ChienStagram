package com.exalt.data.mappers

import com.exalt.data.ModelDataFactory.getOwnerDTO
import com.exalt.domain.home.models.DomainModelFactory.getDefaultLocation
import com.exalt.domain.home.models.DomainModelFactory.getDefaultOwnerModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class OwnerMapperTest {

    private val locationMapper: LocationMapper = mockk()
    private val ownerMapper = OwnerMapper(locationMapper)

    @Test
    fun `Given a owner DTO, When mapper is called, Then returns a owner model`() {
        // Given
        val ownerId = UUID.randomUUID().toString()
        val ownerDTO =  getOwnerDTO(ownerId)
        every { locationMapper.fromDto(any()) } returns getDefaultLocation()

        // When
        val actualOwnerModel = ownerMapper.fromDto(ownerDTO)
        val expectedOwnerModel = getDefaultOwnerModel(ownerId)

        // Then
        assertEquals(expectedOwnerModel, actualOwnerModel)
    }
}