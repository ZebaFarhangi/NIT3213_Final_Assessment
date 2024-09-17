package com.example.androidappdev.login

import com.example.androidappdev.dashboard.DashboardApiService
import com.example.androidappdev.data.api.AuthService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestfulApiRetrofit {
    private val BASE_URL = "https://vu-nit3213-api.onrender.com"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    //private val getDashboardApiService

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

    //val apiService: DashboardApiService = retrofit.create(DashboardApiService::class.java)
    val apiService: DashboardApiService = retrofit.create(DashboardApiService::class.java)




}