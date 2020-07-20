package com.example.example

import com.google.gson.annotations.SerializedName

   
data class AdministrativeArea (

   @SerializedName("AdministrativeAreaName") var AdministrativeAreaName : String,
   @SerializedName("SubAdministrativeArea") var SubAdministrativeArea : SubAdministrativeArea

)