package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Meta (

   @SerializedName("updated_at") var updatedAt : String,
   @SerializedName("units") var units : Units

)