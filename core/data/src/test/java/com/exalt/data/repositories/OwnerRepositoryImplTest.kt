package com.exalt.data.repositories

import com.exalt.api.services.RemoteService
import com.exalt.data.ModelDataFactory.getOwnerDTO
import com.exalt.core.data.exceptions.OwnerNotFoundException
import com.exalt.core.data.mappers.OwnerMapper
import com.exalt.core.data.repositories.OwnerRepositoryImpl
import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultOwnerModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response
import java.util.*

class OwnerRepositoryImplTest {
    private val remoteService: RemoteService = mockk()
    private val ownerMapper: OwnerMapper = mockk()
    private val ownerRepositoryImpl = OwnerRepositoryImpl(remoteService, ownerMapper)

    @Test
    fun `Given a successful response with an Owner from an Id, When getting a Owner through repository, Then returns a Owner`() =
        runTest {
            // Given
            val id = UUID.randomUUID().toString()
            val expectedOwnerDTO = getOwnerDTO(id)
            val expectedOwner = getDefaultOwnerModel(id)

            coEvery { remoteService.getUserById(id) } returns Response.success(expectedOwnerDTO)
            coEvery { ownerMapper.fromDto(expectedOwnerDTO) } returns expectedOwner

            // When
            val actualOwner = ownerRepositoryImpl.getUserBy(id)

            // Then
            assertEquals(expectedOwner, actualOwner)
        }

    @Test(expected = OwnerNotFoundException::class)
    fun `Given a not found Owner response, When getting an Owner through repository, Then throws a OwnerNotFoundException`() =
        runTest {
            // Given
            coEvery { remoteService.getUserById("") } returns Response.error(
                404,
                ResponseBody.create(MediaType.get("application/json"), "RESOURCE_NOT_FOUND")
            )

            // When
            ownerRepositoryImpl.getUserBy("")
        }

}