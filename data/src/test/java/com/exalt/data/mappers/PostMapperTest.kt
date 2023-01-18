package com.exalt.data.mappers

import android.content.res.Resources
import com.exalt.data.ModelDataFactory.getPostDTO
import com.exalt.data.extensions.getLocale
import com.exalt.domain.home.models.DomainModelFactory.getDefaultOwnerPreviewModel
import com.exalt.domain.home.models.DomainModelFactory.getDefaultPostModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class PostMapperTest {
    @MockK
    private lateinit var resources: Resources
    private val ownerPreviewMapper: OwnerPreviewMapper = mockk()
    private lateinit var postMapper: PostMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mockkStatic(Resources::getLocale)
        every { resources.getLocale() } returns Locale.FRANCE
        postMapper = PostMapper(ownerPreviewMapper, resources)

    }

    @Test
    fun `Given a post DTO, When mapper is called, Then returns a post model`() {
        // Given
        val postId = UUID.randomUUID().toString()
        val postDTO = getPostDTO(postId)

        every { ownerPreviewMapper.fromDto(any()) } returns getDefaultOwnerPreviewModel()

        // When
        val actualPostModel = postMapper.fromDto(postDTO)
        val expectedPostModel = getDefaultPostModel(postId)

        // Then
        assertEquals(expectedPostModel, actualPostModel)
    }
}