package com.example.example

import com.google.gson.annotations.SerializedName

   
data class GeocoderResponseMetaData (

   @SerializedName("Point") var Point : Point,
   @SerializedName("request") var request : String,
   @SerializedName("results") var results : String,
   @SerializedName("found") var found : String

)