package com.nightcoder.testapp.api

import com.nightcoder.testapp.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface SampleApi {
    @GET("/public/v2/users")
    suspend fun getPost(): Response<List<Post>>
}