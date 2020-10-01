package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api.api.ApiClient
import com.example.api.model.News
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var apiClient = ApiClient()

        var apiCall = apiClient.getEverything()

        apiCall.enqueue(object : retrofit2.Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
              txtResult.text = t.toString()
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                txtResult.text = response.body()?.articles?.get(0)?.toString()
            }
        })
    }
}