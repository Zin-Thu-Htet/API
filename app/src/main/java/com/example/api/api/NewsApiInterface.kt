package com.example.api.api

import com.example.api.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET("everythings")
    fun getEverything(
        @Query("q") keyword: String,
        @Query("apiKey") apiKey: String
    ) : Call<News>
}