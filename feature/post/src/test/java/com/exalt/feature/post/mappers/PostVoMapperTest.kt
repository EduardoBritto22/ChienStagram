package com.exalt.feature.post.mappers

import android.content.res.Resources
import com.exalt.core.data.extensions.getLocale
import com.exalt.core.domain.home.models.DomainModelFactory
import com.exalt.feature.post.PostFeatureVOsFactory.getDefaultPostVO
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import org.joda.time.LocalDateTime
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class PostVoMapperTest {
    @MockK
    private lateinit var resources: Resources
    private lateinit var postVoMapper : PostVoMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        mockkStatic(Resources::getLocale)
        every { resources.getLocale() } returns Locale.FRANCE

        //Set a static date time to 18/01/2023 0h0
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() } returns LocalDateTime(2022,1,18,0,0)

        postVoMapper = PostVoMapper(resources)

    }
    @Test
    fun `Given a Post Model, when mapper is called, Then returns a PostVO`() {
        // Given
        val randomUuid = UUID.randomUUID().toString()

        // When
        val actualPostVO = postVoMapper.toPostVO(
            DomainModelFactory.getDefaultPostModel(
                randomUuid
            )
        )
        val expectedPostVO =  getDefaultPostVO(randomUuid)

        // Then
        Assert.assertEquals(expectedPostVO, actualPostVO)
    }

    @Test
    fun `Given a null Post Model, when mapper is called, Then returns null`() {
        // Given
        val postModel = null

        // When
        val actualPostVO = postVoMapper.toPostVO(postModel)


        // Then
        Assert.assertNull(actualPostVO)
    }

}