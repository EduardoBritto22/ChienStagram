package com.exalt.core.domain.home.repositories

import com.exalt.core.domain.home.models.OwnerModel

interface OwnerRepository {
    suspend fun getUserBy(id: String): OwnerModel
}