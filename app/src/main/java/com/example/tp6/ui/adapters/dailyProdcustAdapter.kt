package com.example.tp6.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp6.R
import com.example.tp6.core.models.DailyProdcustData
import com.example.tp6.core.models.WeatherData

class DailyProdcustAdapter(private var dataList: List<WeatherData>) :
    RecyclerView.Adapter<DailyProdcustAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.daily_prodcust_item, parent, false) // Replace with your layout name
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        holder.humidity.text = data.humidity.toString()
        holder.description.text = data.description
        holder.pressure.text = data.pressure.toString()
        holder.temp.text = data.temp.toString()
        holder.date.text=data.date
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val humidity: TextView = itemView.findViewById(R.id.humidity) // Replace with your TextView IDs
        val description: TextView = itemView.findViewById(R.id.description)
        val pressure: TextView = itemView.findViewById(R.id.pressure)
        val temp: TextView = itemView.findViewById(R.id.temp)
        val date: TextView = itemView.findViewById(R.id.date)
    }
    fun updateList(newList: List<WeatherData>) {
        dataList = newList
        notifyDataSetChanged()
    }
}