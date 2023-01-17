package com.exalt.domain.home.usecases

import com.exalt.domain.home.models.DomainModelFactory
import com.exalt.domain.home.repositories.CommentRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class GetCommentsUseCaseTest {
    private val commentRepository: CommentRepository = mockk()
    private val getCommentsByPostUseCase = GetCommentsByPostUseCase(commentRepository)

    @Test
    fun `Given repository returns full list, When GetCommentsByPostUseCase is invoked, Then returns full list`() = runTest {

        val postId = UUID.randomUUID().toString()

        // Given
        val expectedCommentsList = List(20) {
            DomainModelFactory.getDefaultCommentModel(UUID.randomUUID().toString())
        }

        coEvery { commentRepository.getCommentsByPost(postId) } returns expectedCommentsList

        // When
        val actualCommentsList = getCommentsByPostUseCase.invoke(postId)

        // Then
        assertEquals(expectedCommentsList, actualCommentsList)
    }


    @Test
    fun `Given repository returns empty list, When GetCommentsByPostUseCase is invoked, Then returns empty list`() = runTest {
        val postId = UUID.randomUUID().toString()

        // Given
        coEvery { commentRepository.getCommentsByPost(postId) } returns emptyList()

        // When
        val postsList = getCommentsByPostUseCase.invoke(postId)

        // Then
        Assert.assertTrue(postsList.isEmpty())
    }

    @Test
    fun `Given repository throws exception, When GetCommentsByPostUseCase is invoked, Then returns empty list`() = runTest {
        val postId = UUID.randomUUID().toString()

        // Given
        coEvery { commentRepository.getCommentsByPost(postId) } throws NullPointerException()

        // When
        val postsList = getCommentsByPostUseCase.invoke(postId)

        // Then
        Assert.assertTrue(postsList.isEmpty())
    }
}