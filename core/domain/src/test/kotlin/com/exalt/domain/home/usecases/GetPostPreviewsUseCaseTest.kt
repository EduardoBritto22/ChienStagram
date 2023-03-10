package com.exalt.domain.home.usecases

import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultPostPreviewModel
import com.exalt.core.domain.home.repositories.PostRepository
import com.exalt.core.domain.home.usecases.GetPostPreviewsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.UUID

class GetPostPreviewsUseCaseTest {
    private val postRepository: PostRepository = mockk()
    private val getPostPreviewsUseCase = GetPostPreviewsUseCase(postRepository)

    @Test
    fun `Given repository returns full list, When GetPostPreviewsUseCase is invoked, Then returns full list`() = runTest {
        // Given
        val expectedPostsList = List(23) {
            getDefaultPostPreviewModel(UUID.randomUUID().toString())
        }

        coEvery { postRepository.getPosts(0u) } returns expectedPostsList

        // When
        val actualPostsList = getPostPreviewsUseCase.invoke()

        // Then
        assertEquals(expectedPostsList, actualPostsList)
    }

    @Test
    fun `Given repository returns empty list, When GetPostPreviewsUseCase is invoked, Then returns empty list`() = runTest {
        // Given
        coEvery { postRepository.getPosts(23u) } returns emptyList()

        // When
        val postsList = getPostPreviewsUseCase.invoke()

        // Then
        assertTrue(postsList.isEmpty())
    }

    @Test
    fun `Given repository throws exception, When GetPostPreviewsUseCase is invoked, Then returns empty list`() = runTest {
        // Given
        coEvery { postRepository.getPosts(23u) } throws NullPointerException()

        // When
        val postsList = getPostPreviewsUseCase.invoke()

        // Then
        assertTrue(postsList.isEmpty())
    }
}