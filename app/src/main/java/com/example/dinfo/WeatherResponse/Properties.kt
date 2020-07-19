package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Properties (

   @SerializedName("meta") var meta : Meta,
   @SerializedName("timeseries") var timeseries : List<Timeseries>

)