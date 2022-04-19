package com.nightcoder.testapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nightcoder.testapp.models.Post
import com.nightcoder.testapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repo: Repository) : ViewModel() {
    val response: MutableLiveData<Response<List<Post>>> by lazy {
        MutableLiveData<Response<List<Post>>>()
    }

    fun getPost() {
        viewModelScope.launch {
            val resp = repo.getPost()
            response.value = resp
        }
    }
}