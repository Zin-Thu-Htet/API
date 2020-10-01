package com.example.api.api

import com.example.api.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val Base_URL = "http://newsapi.org/v2/"

    val apiInterface: NewsApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            NewsApiInterface::class.java
        )
    }

    fun getEverything(): Call<News>{
        return  apiInterface.getEverything(
            "bitcoin","1d9dd1d1ee7d4d2692ff0f951f8fdfd3"
        )
    }
}