package com.example.dinfo.HolidayResponse

import com.google.gson.annotations.SerializedName


data class Date(

    @SerializedName("name") val name: String,
    @SerializedName("numeric") val numeric: Int
)