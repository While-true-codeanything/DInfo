package com.example.example

import com.google.gson.annotations.SerializedName


data class Geometry(

    @SerializedName("type") var type: String,
    @SerializedName("coordinates") var coordinates: List<Double>

)