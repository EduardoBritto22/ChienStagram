package com.exalt.domain.home.usecases

import com.exalt.domain.home.models.OwnerModel
import com.exalt.domain.home.repositories.OwnerRepository
import javax.inject.Inject

class GetOwnerUseCase @Inject constructor(
    private val ownerRepository: OwnerRepository
) {
    suspend fun invoke(id: String): OwnerModel? = runCatching {
        ownerRepository.getUserBy(id)
    }.getOrNull()
}