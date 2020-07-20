package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Address (

   @SerializedName("country_code") var countryCode : String,
   @SerializedName("formatted") var formatted : String,
   @SerializedName("Components") var Components : List<Components>

)