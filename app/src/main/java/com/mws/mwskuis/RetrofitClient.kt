package com.mws.mwskuis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient{
    private const val BASE_URL = "https://type.fit/api/"

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api :: class.java)
    }
}