package com.example.tp6.core.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp6.core.services.DailyProcustService
import com.example.tp6.core.services.WeatherService

class DailyProductVmFactory(private val dailyProdcustService: DailyProcustService = DailyProcustService()) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DailyProdcustVm::class.java)) {
            return DailyProdcustVm(dailyProdcustService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    }