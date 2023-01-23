package com.exalt.feature.post.mappers

import android.content.res.Resources
import com.exalt.core.data.extensions.getLocale
import com.exalt.core.domain.home.models.CommentModel
import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.feature.post.PostFeatureVOsFactory.getDefaultCommentVO
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import org.joda.time.LocalDateTime
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class CommentVoMapperTest {
    @MockK
    private lateinit var resources: Resources
    private lateinit var commentVoMapper : CommentVoMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mockkStatic(Resources::getLocale)
        every { resources.getLocale() } returns Locale.FRANCE

        //Set a static date time to 18/01/2023 0h0
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() } returns LocalDateTime(2022,1,18,0,0)

        commentVoMapper = CommentVoMapper(resources)

    }
    @Test
    fun `Given list of Comment Model, when mapper is called, Then returns list of CommentVO`() {
        every {
            resources.getString(any(),eq(1L))
        } returns "1 a"

        // Given
        val randomUuids = List(23) { UUID.randomUUID().toString() }

        // When
        val actualCommentVO = commentVoMapper.toListCommentVO(randomUuids.map {
            DomainModelFactory.getDefaultCommentModel(
                it
            )
        })
        val expectedCommentVO = randomUuids.map { getDefaultCommentVO(it) }

        // Then
        Assert.assertEquals(expectedCommentVO, actualCommentVO)
    }

    @Test
    fun `Given empty list of Comment Model, when mapper is called, Then returns empty list of CommentVO`() {
        // Given
        val commentModels = emptyList<CommentModel>()

        // When
        val actualCommentVO = commentVoMapper.toListCommentVO(commentModels)

        // Then
        Assert.assertTrue(actualCommentVO.isEmpty())
    }
}