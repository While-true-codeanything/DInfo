package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Timeseries (

   @SerializedName("time") var time : String,
   @SerializedName("data") var data : Data

)