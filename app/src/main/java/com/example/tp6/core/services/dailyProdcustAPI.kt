package com.example.tp6.core.services

import com.example.tp6.core.models.prodcust
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DailyProdcustAPI {

    @GET("daily")
    fun getWeather(@Query("q") q: String, @Query("APPID") appId: String): Call<prodcust>
}