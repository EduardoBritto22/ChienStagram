package com.exalt.domain.home.usecases

import com.exalt.domain.home.models.OwnerModel
import com.exalt.domain.home.repositories.UserRepository
import javax.inject.Inject

class GetOwnerUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun invoke(id: String): OwnerModel? = runCatching {
        userRepository.getUserBy(id)
    }.getOrNull()
}