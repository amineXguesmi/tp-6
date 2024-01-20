package com.example.tp6.core.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp6.core.models.WeatherApiResponse
import com.example.tp6.core.models.WeatherData
import com.example.tp6.core.services.WeatherService
import java.util.*

class WeatherViewModel( private val weatherService: WeatherService = WeatherService()
) : ViewModel() {


    val weatherData: MutableLiveData<WeatherData> by lazy {
        MutableLiveData<WeatherData>()
    }

    fun loadDataTN() {
        var data = weatherService.getWeatherTN()
        Log.d("WeatherViewModel", "loadDataTN: " + data.request().url())
        data.enqueue(object : retrofit2.Callback<WeatherApiResponse> {
            override fun onResponse(
                call: retrofit2.Call<WeatherApiResponse>,
                response: retrofit2.Response<WeatherApiResponse>
            ) {
                if (response.isSuccessful) {
                    println("response is successful")
                    var weather = response.body()!!
                    var _data = WeatherData()
                    _data.date = Date(weather.dt.toLong()*1000).toString()
                    _data.image=weather.weather[0].icon
                    _data.humidity = weather.main.humidity
                    _data.pressure = weather.main.pressure
                    _data.description = weather.weather[0].description
                    _data.temp = weather.main.temp
                    weatherData.value = _data
                } else {
                    println("response is not successful")
                    println(response.errorBody())
                }
            }
            override fun onFailure(call: retrofit2.Call<WeatherApiResponse>, t: Throwable) {
                println("response is not successful")

                println(t.message.toString())
            }

        })

    }

    fun loadData(location: String,appId: String) {
        var data = weatherService.getWeatherByCity(location,appId)
        data.enqueue(object : retrofit2.Callback<WeatherApiResponse> {
            override fun onResponse(
                call: retrofit2.Call<WeatherApiResponse>,
                response: retrofit2.Response<WeatherApiResponse>
            ) {
                if (response.isSuccessful) {
                    println("response is successful")
                    var weather = response.body()!!
                    var _data = WeatherData()

                    _data.date = Date(weather.dt.toLong()*1000).toString()
                    _data.image=weather.weather[0].icon
                    _data.humidity = weather.main.humidity
                    _data.pressure = weather.main.pressure
                    _data.description = weather.weather[0].description
                    _data.temp = weather.main.temp
                    weatherData.value = _data
                } else {
                    println("response is not successful")
                    println(response.errorBody())
                }
            }

            override fun onFailure(call: retrofit2.Call<WeatherApiResponse>, t: Throwable) {
                println("response is not successful")

                println(t.message.toString())
            }
        })

    }
}