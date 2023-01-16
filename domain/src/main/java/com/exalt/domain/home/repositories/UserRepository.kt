package com.exalt.domain.home.repositories

import com.exalt.domain.home.models.OwnerModel
import com.exalt.domain.home.models.OwnerPreviewModel

interface UserRepository {
    suspend fun getUsers(page: UInt): List<OwnerPreviewModel>

    suspend fun getUserBy(id: String): OwnerModel
}