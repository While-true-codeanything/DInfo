package com.example.dinfo.HolidayResponse

import com.google.gson.annotations.SerializedName


data class MainHolidayResponse(

    @SerializedName("status") val status: Int,
    @SerializedName("warning") val warning: String,
    @SerializedName("requests") val requests: Requests,
    @SerializedName("holidays") val holidays: List<Holidays>
)