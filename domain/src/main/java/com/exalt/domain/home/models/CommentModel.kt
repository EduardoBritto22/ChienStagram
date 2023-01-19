package com.exalt.domain.home.models

import org.joda.time.Duration

data class CommentModel(
    val id: String,
    val message: String,
    val post: String,
    val durationFromPublishDate: Duration,
    val owner: OwnerPreviewModel
)
