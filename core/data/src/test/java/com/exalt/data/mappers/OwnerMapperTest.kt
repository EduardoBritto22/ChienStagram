package com.exalt.data.mappers

import com.exalt.core.data.mappers.LocationMapper
import com.exalt.core.data.mappers.OwnerMapper
import com.exalt.data.ModelDataFactory.getOwnerDTO
import com.exalt.domain.home.models.DomainModelFactory.getDefaultLocation
import com.exalt.domain.home.models.DomainModelFactory.getDefaultOwnerModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.joda.time.LocalDateTime
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class OwnerMapperTest {

    private val locationMapper: LocationMapper = mockk()
    private val ownerMapper = OwnerMapper(locationMapper)

    @Before
    fun setUp(){
        //Set a static date time to 18/01/2023 0h0
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() } returns LocalDateTime(2023,1,18,0,0)
    }


    @Test
    fun `Given a owner DTO, When mapper is called, Then returns a owner model`() {
        // Given
        val ownerId = UUID.randomUUID().toString()
        val ownerDTO =  getOwnerDTO(ownerId)
        every { locationMapper.fromDto(any()) } returns getDefaultLocation()
        val expectedOwnerModel = getDefaultOwnerModel(ownerId)

        // When
        val actualOwnerModel = ownerMapper.fromDto(ownerDTO)

        // Then
        assertEquals(expectedOwnerModel, actualOwnerModel)
    }
}