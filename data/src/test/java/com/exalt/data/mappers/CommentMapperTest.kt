package com.exalt.data.mappers

import com.exalt.api.models.CommentDTO
import com.exalt.data.ModelDataFactory.getCommentDTO
import com.exalt.domain.home.models.DomainModelFactory.getDefaultCommentModel
import com.exalt.domain.home.models.DomainModelFactory.getDefaultOwnerPreviewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.UUID

class CommentMapperTest {
    private val ownerPreviewMapper: OwnerPreviewMapper = mockk()
    private val commentMapper = CommentMapper(ownerPreviewMapper)

    @Test
    fun `Given list of comment DTOs, When mapper is called, Then returns list of comment models`() {
        // Given
        val randomUuids = List(23) { UUID.randomUUID().toString() }
        val commentDTOs = randomUuids.map { getCommentDTO(it) }
        every { ownerPreviewMapper.fromDto(any()) } returns getDefaultOwnerPreviewModel()

        // When
        val actualCommentModels = commentMapper.fromListDto(commentDTOs)
        val expectedCommentModels = randomUuids.map { getDefaultCommentModel(it) }

        // Then
        assertEquals(expectedCommentModels, actualCommentModels)
    }

    @Test
    fun `Given empty list of comment DTOs, When mapper is called, Then returns empty list of comment models`() {
        // Given
        val commentDTOS = emptyList<CommentDTO>()

        // When
        val commentModels = commentMapper.fromListDto(commentDTOS)

        // Then
        assertTrue(commentModels.isEmpty())
    }
}