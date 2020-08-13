package com.example.dinfo.HolidayResponse

import com.google.gson.annotations.SerializedName

data class Weekday(

    @SerializedName("date") val date: Date,
    @SerializedName("observed") val observed: Observed
)