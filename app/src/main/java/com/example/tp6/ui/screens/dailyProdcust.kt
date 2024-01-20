package com.example.tp6.ui.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp6.MainActivity
import com.example.tp6.core.services.DailyProcustService
import com.example.tp6.core.viewModels.DailyProdcustVm
import com.example.tp6.core.viewModels.DailyProductVmFactory
import com.example.tp6.databinding.ActivityDailyProdcustBinding
import com.example.tp6.ui.adapters.DailyProdcustAdapter

class DailyProdcust : AppCompatActivity() {

    lateinit var binding:ActivityDailyProdcustBinding
    lateinit var recycleView:RecyclerView
    lateinit var prevButton:Button

    private lateinit var adapter: DailyProdcustAdapter
    private val dailyProcustService = DailyProcustService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDailyProdcustBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recycleView=binding.recyclerView
        prevButton=binding.prev
        recycleView.layoutManager = LinearLayoutManager(this)
        adapter = DailyProdcustAdapter(emptyList())
        viewModel.weatherDailyData.observe(this) { data ->
            if(data!=null){
                adapter.updateList(data.toList())

        }
        }
        var location=intent.getStringExtra("country")
        if(location!=null){
            viewModel.loadData(location, "17db59488cadcad345211c36304a9266")
        }else{
            viewModel.loadData("London", "17db59488cadcad345211c36304a9266")
        }
        recycleView.adapter = adapter

        prevButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}
    }

    private val viewModel : DailyProdcustVm by viewModels() {
        DailyProductVmFactory(dailyProcustService)
    }
}