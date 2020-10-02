package com.example.api.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.api.api.ApiClient
import com.example.api.model.ArticlesItem
import com.example.api.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewmodel: ViewModel(){

    //LiveData=Immutable     //MutableLiveData

    private var news: MutableLiveData<News> = MutableLiveData()

        fun getArticle(): LiveData<News> = news

        fun loadArticle() {

            var apiClient = ApiClient()

            var apiCall = apiClient.getEverything()

            apiCall.enqueue(object : Callback<News> {
                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.d("Error>>>", t.toString())
                }

                override fun onResponse(call: Call<News>, response: Response<News>) {
                    news.value = response.body()
                }
            })
        }
}