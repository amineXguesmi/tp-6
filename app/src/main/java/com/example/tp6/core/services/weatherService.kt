package com.example.tp6.core.services

import com.example.tp6.core.models.WeatherApiResponse
import retrofit2.Call

class WeatherService : WeatherAPI {
    override fun getWeatherTN(): Call<WeatherApiResponse> {
        val response =  RetrofitHelper.retrofitService.getWeatherTN()
        println(response.request().url())
        return response
    }
    override fun getWeatherByCity(cityName: String, apiKey: String): Call<WeatherApiResponse> {
        val response =  RetrofitHelper.retrofitService.getWeatherByCity(cityName,apiKey)
        println(response.request().url())
        return response
    }


}