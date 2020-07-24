package com.example.dinfo.HolidayResponse

import com.google.gson.annotations.SerializedName


data class Holidays(

    @SerializedName("name") val name: String,
    @SerializedName("date") val date: String,
    @SerializedName("observed") val observed: String,
    @SerializedName("public") val public: Boolean,
    @SerializedName("country") val country: String,
    @SerializedName("uuid") val uuid: String,
    @SerializedName("weekday") val weekday: Weekday
)