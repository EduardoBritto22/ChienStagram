package com.exalt.data.mappers

import com.exalt.api.models.CommentDTO
import com.exalt.core.data.mappers.CommentMapper
import com.exalt.core.data.mappers.OwnerPreviewMapper
import com.exalt.data.ModelDataFactory.getCommentDTO
import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultCommentModel
import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultOwnerPreviewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.joda.time.LocalDateTime
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.*

class CommentMapperTest {

    private val ownerPreviewMapper: OwnerPreviewMapper = mockk()
    private lateinit var commentMapper : CommentMapper

    @Before
    fun setUp(){

        //Set a static date time to 18/01/2023 0h0
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() } returns LocalDateTime(2023,1,18,0,0)
        commentMapper = CommentMapper(ownerPreviewMapper)
    }

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