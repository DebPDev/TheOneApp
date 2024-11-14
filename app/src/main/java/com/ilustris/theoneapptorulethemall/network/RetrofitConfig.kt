package com.ilustris.theoneapptorulethemall.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitConfig {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Set the desired logging level
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    val retrofitConfig by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl("https://caioprogramming.github.io/FellowshipFacts/data/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

const val API_KEY = "ubTv4QeO7JACgmKCfl6L "