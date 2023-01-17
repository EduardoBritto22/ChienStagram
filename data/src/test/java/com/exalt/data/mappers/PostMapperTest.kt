package com.exalt.data.mappers

import com.exalt.data.ModelDataFactory.getPostDTO
import com.exalt.domain.home.models.DomainModelFactory.getDefaultOwnerPreviewModel
import com.exalt.domain.home.models.DomainModelFactory.getDefaultPostModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class PostMapperTest {
    private val ownerPreviewMapper: OwnerPreviewMapper = mockk()
    private val postMapper = PostMapper(ownerPreviewMapper)

    @Test
    fun `Given a post DTO, When mapper is called, Then returns a post model`() {
        // Given
        val postId = UUID.randomUUID().toString()
        val postDTO =  getPostDTO(postId)
        every { ownerPreviewMapper.fromDto(any()) } returns getDefaultOwnerPreviewModel()

        // When
        val actualPostModel = postMapper.fromDto(postDTO)
        val expectedPostModel = getDefaultPostModel(postId)

        // Then
        assertEquals(expectedPostModel, actualPostModel)
    }
}