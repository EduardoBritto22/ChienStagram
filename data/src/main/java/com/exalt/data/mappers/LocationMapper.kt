package com.exalt.data.mappers

import com.exalt.api.models.LocationDTO
import com.exalt.domain.home.models.LocationModel
import javax.inject.Inject

class LocationMapper @Inject constructor() {
    fun fromDto(location: LocationDTO): LocationModel =
        LocationModel("${location.street}\n${location.city} - ${location.state}\n${location.country}")
}