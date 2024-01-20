package com.example.tp6.core.services


import com.example.tp6.core.models.WeatherApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("weather?q=Tunis&APPID=17db59488cadcad345211c36304a9266")
    fun getWeatherTN() : Call<WeatherApiResponse>

    @GET("weather")
    fun getWeatherByCity(@Query("q") cityName: String, @Query("APPID") apiKey: String): Call<WeatherApiResponse>


}
