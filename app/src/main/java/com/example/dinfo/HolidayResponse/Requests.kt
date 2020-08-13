package com.example.dinfo.HolidayResponse

import com.google.gson.annotations.SerializedName


data class Requests(

    @SerializedName("used") val used: Int,
    @SerializedName("available") val available: Int,
    @SerializedName("resets") val resets: String
)