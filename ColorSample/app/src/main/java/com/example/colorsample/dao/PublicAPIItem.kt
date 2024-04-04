package com.example.colorsample.dao


import com.example.colorsample.utils.EMPTY_STRING
import com.example.colorsample.utils.ZERO_DOUBLE
import com.example.colorsample.utils.ZERO_INT
import com.google.gson.annotations.SerializedName

data class PublicAPIItem(
    @SerializedName("apiUrl")
    val apiUrl: String = EMPTY_STRING,
    @SerializedName("badgeUrl")
    val badgeUrl: String = EMPTY_STRING,
    @SerializedName("dateCreated")
    val dateCreated: String = EMPTY_STRING,
    @SerializedName("description")
    val description: String = EMPTY_STRING,
    @SerializedName("hex")
    val hex: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String = EMPTY_STRING,
    @SerializedName("numComments")
    val numComments: Int = ZERO_INT,
    @SerializedName("numHearts")
    val numHearts: Double = ZERO_DOUBLE,
    @SerializedName("numViews")
    val numViews: Int = ZERO_INT,
    @SerializedName("numVotes")
    val numVotes: Int = ZERO_INT,
    @SerializedName("rank")
    val rank: Int = ZERO_INT,
    @SerializedName("rgb")
    val rgb: Rgb,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("userName")
    val userName: String = EMPTY_STRING
)


