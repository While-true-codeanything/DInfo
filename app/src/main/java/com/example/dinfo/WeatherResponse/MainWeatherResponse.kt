package com.example.example

import com.google.gson.annotations.SerializedName

   
data class MainWeatherResponse (

   @SerializedName("type") var type : String,
   @SerializedName("geometry") var geometry : Geometry,
   @SerializedName("properties") var properties : Properties

)