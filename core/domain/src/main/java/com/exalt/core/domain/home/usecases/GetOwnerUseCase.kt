package com.exalt.core.domain.home.usecases

import com.exalt.core.domain.home.extensions.getAgeInYears
import com.exalt.core.domain.home.models.OwnerModel
import com.exalt.core.domain.home.repositories.OwnerRepository
import javax.inject.Inject

class GetOwnerUseCase @Inject constructor(
    private val ownerRepository: OwnerRepository
) {
    companion object {
        const val LEGAL_AGE = 18
    }
    suspend fun invoke(id: String): OwnerModel? = runCatching {

        val owner = ownerRepository.getUserBy(id)
        val ownerAge = owner.dateOfBirth.getAgeInYears()

        if (ownerAge < LEGAL_AGE) {
            return owner.copy(pictureUrl = "")
        }

        return owner

    }.getOrNull()

}