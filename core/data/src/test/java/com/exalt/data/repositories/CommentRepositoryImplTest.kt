package com.exalt.data.repositories

import com.exalt.api.models.Page
import com.exalt.api.services.RemoteService
import com.exalt.data.ModelDataFactory.getCommentDTO
import com.exalt.core.data.mappers.CommentMapper
import com.exalt.core.data.repositories.CommentRepositoryImpl
import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultCommentModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response
import java.util.*

class CommentRepositoryImplTest {
    private val remoteService: RemoteService = mockk()
    private val commentMapper: CommentMapper = mockk()
    private val commentRepositoryImpl = CommentRepositoryImpl(remoteService, commentMapper)

    @Test
    fun `Given a successful response with comments on page 23, When getting comments through repository, Then returns list of Comments`() =
        runTest {
            // Given
            val postId = UUID.randomUUID().toString()
            val page = 23u
            val randomUuids = List(50) { UUID.randomUUID().toString() }
            val commentsDTOs = randomUuids.map { getCommentDTO(it) }
            val expectedComments = randomUuids.map { getDefaultCommentModel(it) }
            coEvery { remoteService.getCommentsByPost(postId, page) } returns Response.success(
                Page(
                    data = commentsDTOs,
                    total = page
                )
            )
            coEvery { commentMapper.fromListDto(commentsDTOs) } returns expectedComments

            // When
            val actualComments = commentRepositoryImpl.getCommentsByPost(postId, page)

            // Then
            assertEquals(expectedComments, actualComments)
        }

    @Test
    fun `Given a successful response with no comments on page 0, When getting comments through repository, Then returns an empty list`() =
        runTest {
            // Given
            val postId = UUID.randomUUID().toString()
            val page = 0u
            coEvery { remoteService.getCommentsByPost(postId, page) } returns Response.success(
                Page(
                    data = emptyList(),
                    total = page
                )
            )
            coEvery { commentMapper.fromListDto(emptyList()) } returns emptyList()

            // When
            val comments = commentRepositoryImpl.getCommentsByPost(postId, page)

            // Then
            assertTrue(comments.isEmpty())
        }

    @Test
    fun `Given an error response, When getting comments through repository, Then returns an empty list`() =
        runTest {
            // Given
            val postId = UUID.randomUUID().toString()
            val page = 0u
            coEvery { remoteService.getCommentsByPost(postId, page) } returns Response.error(
                404,
                ResponseBody.create(MediaType.get("application/json"), "HTTP NOT FOUND")
            )

            // When
            val comments = commentRepositoryImpl.getCommentsByPost(postId, page)

            // Then
            assertTrue(comments.isEmpty())
        }
}