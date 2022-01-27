package com.example.vidlern.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://www.udemy.com/api-2.0/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object RetrofitClient {
    val API_SERVICE: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}