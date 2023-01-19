package com.exalt.home.mappers

import android.content.res.Resources
import com.exalt.data.extensions.getLocale
import com.exalt.domain.home.models.DomainModelFactory.getDefaultPostPreviewModel
import com.exalt.domain.home.models.PostPreviewModel
import com.exalt.home.HomeVOFactory.getDefaultPostVO
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.*

class PostPreviewMapperTest {
    @MockK
    private lateinit var resources: Resources
    private lateinit var postPreviewMapper : PostPreviewMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mockkStatic(Resources::getLocale)
        every { resources.getLocale() } returns Locale.FRANCE
        postPreviewMapper = PostPreviewMapper(resources)

    }
    @Test
    fun `Given list of Post Preview Model, when mapper is called, Then returns list of PostVO`() {
        // Given
        val randomUuids = List(23) { UUID.randomUUID().toString() }

        // When
        val actualPostVO = postPreviewMapper.toListPostVO(randomUuids.map { getDefaultPostPreviewModel(it) })
        val expectedPostVO = randomUuids.map { getDefaultPostVO(it) }

        // Then
        assertEquals(expectedPostVO, actualPostVO)
    }

    @Test
    fun `Given empty list of Post Preview Model, when mapper is called, Then returns empty list of PostVO`() {
        // Given
        val postPreviewModels = emptyList<PostPreviewModel>()

        // When
        val actualPostVO = postPreviewMapper.toListPostVO(postPreviewModels)

        // Then
        assertTrue(actualPostVO.isEmpty())
    }
}