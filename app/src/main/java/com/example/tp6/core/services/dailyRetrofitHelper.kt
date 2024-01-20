package com.example.tp6.core.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DailyRetrofitHelper {


    private  val baseUrl ="https://api.openweathermap.org/data/2.5/forecast/"
    /**
     * The Retrofit object with Gson converter.
     */
    private val retrofit = Retrofit.Builder().baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    /**
     * A public Api object that exposes the lazy-initialized Retrofit service
     */
    val retrofitService : DailyProdcustAPI by lazy { retrofit.create(DailyProdcustAPI::class.java) }
}