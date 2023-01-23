package com.exalt.data.mappers

import com.exalt.core.data.mappers.LocationMapper
import com.exalt.data.ModelDataFactory.getLocationDTO
import com.exalt.domain.home.models.DomainModelFactory.getDefaultLocation
import org.junit.Assert.assertEquals
import org.junit.Test

class LocationMapperTest {
    private val locationMapper = LocationMapper()

    @Test
    fun `Given a location DTO, When mapper is called, Then returns a location model`() {

        // Given
        val locationDTO =  getLocationDTO()

        // When
        val actualLocationModel = locationMapper.fromDto(locationDTO)
        val expectedLocationModel = getDefaultLocation()

        // Then
        assertEquals(expectedLocationModel, actualLocationModel)
    }
}