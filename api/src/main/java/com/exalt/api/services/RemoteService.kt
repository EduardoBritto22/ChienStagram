package com.exalt.api.services

import com.exalt.api.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteService {
    @GET("post?limit=23")
    suspend fun getPosts(@Query("page") page: UInt): Response<Page<PostPreviewDTO>>

    @GET("post/{id}")
    suspend fun getPostById(@Path("id") id: String): Response<PostDTO>

    @GET("user/{id}")
    suspend fun getUserById(@Path("id") id: String): Response<UserDTO>

    @GET("post/{id}/comment")
    suspend fun getCommentsByPost(
        @Path("id") postId: String,
        @Query("page") page: UInt
    ): Response<Page<CommentDTO>>

}