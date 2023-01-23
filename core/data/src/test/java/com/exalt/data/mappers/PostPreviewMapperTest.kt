package com.exalt.data.mappers

import android.content.res.Resources
import com.exalt.api.models.PostPreviewDTO
import com.exalt.data.ModelDataFactory.getPostPreviewDTO
import com.exalt.core.data.extensions.getLocale
import com.exalt.core.data.mappers.OwnerPreviewMapper
import com.exalt.core.data.mappers.PostPreviewMapper
import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultOwnerPreviewModel
import com.exalt.core.domain.home.models.DomainModelFactory.getDefaultPostPreviewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.*

class PostPreviewMapperTest {

    private val ownerPreviewMapper: OwnerPreviewMapper = mockk()
    private lateinit var postPreviewMapper: PostPreviewMapper

    @Before
    fun setUp() {
        postPreviewMapper = PostPreviewMapper(ownerPreviewMapper)
        mockkStatic(Resources::getLocale)
    }


    @Test
    fun `Given list of post preview DTO, When mapper is called, Then returns list of post preview model`() {
        // Given
        val randomUuids = List(23) { UUID.randomUUID().toString() }
        val postPreviewDTOs = randomUuids.map { getPostPreviewDTO(it) }
        every { ownerPreviewMapper.fromDto(any()) } returns getDefaultOwnerPreviewModel()

        // When
        val actualPostPreviewModels = postPreviewMapper.fromListDto(postPreviewDTOs)
        val expectedPostPreviewModels = randomUuids.map { getDefaultPostPreviewModel(it) }

        // Then
        assertEquals(expectedPostPreviewModels, actualPostPreviewModels)
    }

    @Test
    fun `Given empty list of post preview DTO, When mapper is called, Then returns empty list of post preview model`() {
        // Given
        val postPreviewDTOs = emptyList<PostPreviewDTO>()

        // When
        val postPreviewModel = postPreviewMapper.fromListDto(postPreviewDTOs)

        // Then
        assertTrue(postPreviewModel.isEmpty())
    }
}