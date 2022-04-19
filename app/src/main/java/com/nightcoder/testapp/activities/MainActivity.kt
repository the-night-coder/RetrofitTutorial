package com.nightcoder.testapp.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nightcoder.testapp.R
import com.nightcoder.testapp.models.Post
import com.nightcoder.testapp.repository.Repository
import com.nightcoder.testapp.viewModels.MainViewModel
import com.nightcoder.testapp.viewModels.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = Repository()
        val factory = ViewModelFactory(repo)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        viewModel.getPost()
        viewModel.response.observe(this, {
            if (it.isSuccessful) {
                Log.d("API", "Success")

                for (p: Post in it.body()!!) {
                    Log.d("Naame", p.name)
                }
            }
        })
    }
}