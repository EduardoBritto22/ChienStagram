package com.exalt.domain.home.repositories

import com.exalt.domain.home.models.OwnerModel

interface OwnerRepository {
    suspend fun getUserBy(id: String): OwnerModel
}