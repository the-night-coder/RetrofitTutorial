package com.nightcoder.testapp.repository

import com.nightcoder.testapp.api.RetrofitInstance
import com.nightcoder.testapp.models.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<List<Post>> {
        return RetrofitInstance.api.getPost()
    }
}