package com.exalt.data.repositories

import com.exalt.api.models.Page
import com.exalt.api.services.RemoteService
import com.exalt.data.ModelDataFactory.getPostDTO
import com.exalt.data.ModelDataFactory.getPostPreviewDTO
import com.exalt.core.data.exceptions.PostNotFoundException
import com.exalt.core.data.mappers.PostMapper
import com.exalt.core.data.mappers.PostPreviewMapper
import com.exalt.core.data.repositories.PostRepositoryImpl
import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultPostModel
import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultPostPreviewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert.*
import org.junit.Test
import retrofit2.Response
import java.util.UUID

class PostRepositoryImplTest {
    private val remoteService: RemoteService = mockk()
    private val postPreviewMapper: PostPreviewMapper = mockk()
    private val postMapper: PostMapper = mockk()
    private val postPreviewRepositoryImpl = PostRepositoryImpl(remoteService, postPreviewMapper,postMapper)

    @Test
    fun `Given a successful response with posts on page 23, When getting posts through repository, Then returns list of PostPreview`() = runTest {
        // Given
        val page = 23u
        val randomUuids = List(50) { UUID.randomUUID().toString() }
        val postPreviewDTOs = randomUuids.map { getPostPreviewDTO(it) }
        val expectedPostPreviews = randomUuids.map { getDefaultPostPreviewModel(it) }
        coEvery { remoteService.getPosts(page) } returns Response.success(Page(data = postPreviewDTOs, total = page))
        coEvery { postPreviewMapper.fromListDto(postPreviewDTOs) } returns expectedPostPreviews

        // When
        val actualPostPreviews = postPreviewRepositoryImpl.getPosts(page)

        // Then
        assertEquals(expectedPostPreviews, actualPostPreviews)
    }

    @Test
    fun `Given a successful response with a post from an Id, When getting a Post through repository, Then returns a Post`() = runTest {
        // Given
        val id = UUID.randomUUID().toString()
        val expectedPostDTO = getPostDTO(id)
        val expectedPost = getDefaultPostModel(id)

        coEvery { remoteService.getPostById(id) } returns Response.success(expectedPostDTO)
        coEvery { postMapper.fromDto(expectedPostDTO) } returns expectedPost

        // When
        val actualPost = postPreviewRepositoryImpl.getPostBy(id)

        // Then
        assertEquals(expectedPost, actualPost)
    }

    @Test
    fun `Given a successful response with no post on page 0, When getting posts through repository, Then returns an empty list`() = runTest {
        // Given
        val page = 0u
        coEvery { remoteService.getPosts(page) } returns Response.success(Page(data = emptyList(), total = page))
        coEvery { postPreviewMapper.fromListDto(emptyList()) } returns emptyList()

        // When
        val postPreviews = postPreviewRepositoryImpl.getPosts(page)

        // Then
        assertTrue(postPreviews.isEmpty())
    }

    @Test
    fun `Given an error response, When getting posts through repository, Then returns an empty list`() = runTest {
        // Given
        val page = 0u
        coEvery { remoteService.getPosts(page) } returns Response.error(404, ResponseBody.create(MediaType.get("application/json"), "HTTP NOT FOUND"))

        // When
        val postPreviews = postPreviewRepositoryImpl.getPosts(page)

        // Then
        assertTrue(postPreviews.isEmpty())
    }

    @Test(expected = PostNotFoundException::class)
    fun `Given a not found Post response, When getting a Post through repository, Then throws a PostNotFoundException`() = runTest {
        // Given
        coEvery { remoteService.getPostById("") } returns Response.error(404, ResponseBody.create(MediaType.get("application/json"), "RESOURCE_NOT_FOUND"))

        // When
        postPreviewRepositoryImpl.getPostBy("")
    }



}