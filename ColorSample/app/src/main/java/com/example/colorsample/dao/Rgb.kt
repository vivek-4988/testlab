package com.example.colorsample.dao


import com.google.gson.annotations.SerializedName

data class Rgb(
    @SerializedName("blue")
    val blue: Int,
    @SerializedName("green")
    val green: Int,
    @SerializedName("red")
    val red: Int
)