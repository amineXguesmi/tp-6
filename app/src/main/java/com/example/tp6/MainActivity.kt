package com.example.tp6

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.example.tp6.core.services.WeatherService
import com.example.tp6.core.viewModels.WeatherViewModel
import com.example.tp6.core.viewModels.WeatherViewModelFactory
import com.example.tp6.databinding.ActivityMainBinding
import com.example.tp6.ui.screens.DailyProdcust


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var countryName:TextView
    lateinit var description:TextView
    lateinit var humidity:TextView
    lateinit var pressure:TextView
    lateinit var date:TextView
    lateinit var temp:TextView
    lateinit var spinner: Spinner
    lateinit var buttonNext:Button
    private val weatherService = WeatherService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        countryName = binding.country
        countryName.text = "Tunis"
        description = binding.description
        temp = binding.temp
        humidity = binding.humidity
        pressure = binding.pressure
        date = binding.date
        spinner = binding.spinner
        buttonNext=binding.next

        viewModel.weatherData.observe(this) { weatherData ->
            date.text = weatherData.date
            temp.text = weatherData.temp.toString()
            description.text = weatherData.description
            humidity.text = weatherData.humidity.toString()
            pressure.text = weatherData.pressure.toString()
        }
        Thread {
        viewModel.loadDataTN()
        }.start()
        val items = listOf("Tunis", "Paris", "London","Tokyo")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = items[position]
                countryName.text = selectedItem
                when(selectedItem){
                    "Tunis" -> viewModel.loadData("Tunis","17db59488cadcad345211c36304a9266")
                    "Paris" -> viewModel.loadData("Paris","17db59488cadcad345211c36304a9266")
                    "London" -> viewModel.loadData("London","17db59488cadcad345211c36304a9266")
                    "Tokyo" -> viewModel.loadData("Tokyo","17db59488cadcad345211c36304a9266")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        buttonNext.setOnClickListener {
            val intent = Intent(this, DailyProdcust::class.java)
            intent.putExtra("country", countryName.text)
            startActivity(intent)
        }
    }


    private val viewModel : WeatherViewModel by viewModels() {
        WeatherViewModelFactory(weatherService)
    }
}