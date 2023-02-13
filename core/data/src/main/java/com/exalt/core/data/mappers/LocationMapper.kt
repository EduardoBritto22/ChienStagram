package com.exalt.core.data.mappers

import com.exalt.api.models.LocationDTO
import com.exalt.core.domain.home.models.LocationModel
import javax.inject.Inject

class LocationMapper @Inject constructor() {
    fun fromDto(location: LocationDTO): LocationModel =
        location.run { LocationModel("$street\n$city - $state\n$country") }
}