package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Locality (

   @SerializedName("LocalityName") var LocalityName : String,
   @SerializedName("Premise") var Premise : Premise

)