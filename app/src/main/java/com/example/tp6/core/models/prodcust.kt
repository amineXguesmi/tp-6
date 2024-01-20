package com.example.tp6.core.models


import com.google.gson.annotations.SerializedName

data class prodcust(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("list")
    val list: List<X>,
    @SerializedName("message")
    val message: Double
)