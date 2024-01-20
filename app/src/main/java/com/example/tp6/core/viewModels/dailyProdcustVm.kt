package com.example.tp6.core.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp6.core.models.DailyProdcustData
import com.example.tp6.core.models.WeatherData
import com.example.tp6.core.models.prodcust
import com.example.tp6.core.services.DailyProcustService
import java.util.*

class DailyProdcustVm( private val weatherService: DailyProcustService = DailyProcustService()
) : ViewModel() {
    val weatherDailyData: MutableLiveData<Array<WeatherData>> by lazy {
        MutableLiveData<Array<WeatherData>>()
    }
    fun loadData(location: String,appId: String) {
        var data = weatherService.getWeather(location,appId)
        data.enqueue(object : retrofit2.Callback<prodcust> {
            override fun onResponse(
                call: retrofit2.Call<prodcust>,
                response: retrofit2.Response<prodcust>
            ) {
                if (response.isSuccessful) {
                    println("response is successful")
                    var weather = response.body()!!
                    var list = listOf<WeatherData>()
                    for(daily in weather.list){

                        var data = WeatherData()
                        data.date = Date(daily.dt.toLong()*1000).toString()
                        data.humidity = daily.humidity
                        data.pressure = daily.pressure
                        data.description = daily.weather[0].description
                        data.temp = daily.temp.day
                        list+=data
                    }
                    for (i in list){
                        println(i.humidity)
                    }

                    weatherDailyData.value = list.toTypedArray()
                    println(weatherDailyData.value!!.size)

                } else {
                    println("response is not successful")
                    println(response.errorBody())
                }
            }

            override fun onFailure(call: retrofit2.Call<prodcust>, t: Throwable) {
                println("response is not successful")

                println(t.message.toString())
            }
        })

    }

}