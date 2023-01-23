package com.exalt.domain.home.usecases

import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultPostModel
import com.exalt.core.domain.home.repositories.PostRepository
import com.exalt.core.domain.home.usecases.GetPostUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.util.UUID

class GetPostUseCaseTest {
    private val postRepository: PostRepository = mockk()
    private val getPostUseCase = GetPostUseCase(postRepository)

    @Test
    fun `Given repository returns right post, When GetPostUseCase is invoked with an Id, Then returns the right post`() = runTest {

        val id = UUID.randomUUID().toString()

        // Given
        val expectedPost =  getDefaultPostModel()

        coEvery { postRepository.getPostBy(id) } returns expectedPost

        // When
        val actualPost = getPostUseCase.invoke(id)

        // Then
        assertEquals(expectedPost, actualPost)
    }

    @Test
    fun `Given repository throws exception, When GetPostUseCase is invoked, Then returns null`() = runTest {
        // Given
        coEvery { postRepository.getPostBy("") } throws NullPointerException()

        // When
        val post = getPostUseCase.invoke("")

        // Then
        assertNull(post)
    }
}