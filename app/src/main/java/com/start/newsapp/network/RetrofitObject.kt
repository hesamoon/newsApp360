package com.start.newsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    val newsApiObject: NewsApi by lazy {

        Retrofit.Builder()
            .baseUrl("https://football360.ir/api/cms/")//("https://mockend.com/api/mockend/demo/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }
}