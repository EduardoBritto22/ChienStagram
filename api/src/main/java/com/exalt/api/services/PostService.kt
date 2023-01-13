package com.exalt.api.services

import com.exalt.api.DummyApi
import com.exalt.api.models.Page
import com.exalt.api.models.PostPreviewDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PostService {
    @GET("post?limit=23")
    @Headers("app-id: ${DummyApi.APP_ID}")
    suspend fun getPosts(@Query("page") page: UInt): Response<Page<PostPreviewDTO>>
}