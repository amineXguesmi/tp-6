package com.example.tp6.core.models


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord")
    val coord: CoordX,
    @SerializedName("country")
    val country: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("timezone")
    val timezone: Int
)