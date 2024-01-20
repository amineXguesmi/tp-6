package com.example.tp6.core.services

import com.example.tp6.core.models.prodcust
import com.example.tp6.core.services.DailyRetrofitHelper.retrofitService
import retrofit2.Call

class DailyProcustService:DailyProdcustAPI {
    override fun getWeather(city: String, appId: String): Call<prodcust> {
        val response =  DailyRetrofitHelper.retrofitService.getWeather(city,appId)
        println(response.request().url())
        return response
    }
}