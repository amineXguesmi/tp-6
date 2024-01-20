package com.example.tp6.core.models


import com.google.gson.annotations.SerializedName

data class CoordX(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)