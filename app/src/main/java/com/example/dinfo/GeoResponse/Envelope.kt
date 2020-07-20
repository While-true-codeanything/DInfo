package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Envelope (

   @SerializedName("lowerCorner") var lowerCorner : String,
   @SerializedName("upperCorner") var upperCorner : String

)