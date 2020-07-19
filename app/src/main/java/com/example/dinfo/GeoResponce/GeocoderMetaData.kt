package com.example.example

import com.google.gson.annotations.SerializedName

   
data class GeocoderMetaData (

   @SerializedName("precision") var precision : String,
   @SerializedName("text") var text : String,
   @SerializedName("kind") var kind : String,
   @SerializedName("Address") var Address : Address,
   @SerializedName("AddressDetails") var AddressDetails : AddressDetails

)