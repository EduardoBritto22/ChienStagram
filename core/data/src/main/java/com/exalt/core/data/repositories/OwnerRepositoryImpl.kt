package com.exalt.core.data.repositories

import com.exalt.api.services.RemoteService
import com.exalt.core.data.exceptions.OwnerNotFoundException
import com.exalt.core.data.mappers.OwnerMapper
import com.exalt.domain.home.models.OwnerModel
import com.exalt.domain.home.repositories.OwnerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class OwnerRepositoryImpl @Inject constructor(
    private val remoteService: RemoteService,
    private val ownerMapper: OwnerMapper,
) : OwnerRepository {

    override suspend fun getUserBy(id: String): OwnerModel =
        remoteService.getUserById(id).let { response ->
            if (response.isSuccessful) {
                ownerMapper.fromDto(response.body()!!)
            } else {
                throw OwnerNotFoundException(response.errorBody()?.string())
            }
        }
}