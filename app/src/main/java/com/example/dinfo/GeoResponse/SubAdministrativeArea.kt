package com.example.example

import com.google.gson.annotations.SerializedName


data class SubAdministrativeArea(

    @SerializedName("SubAdministrativeAreaName") var SubAdministrativeAreaName: String,
    @SerializedName("Locality") var Locality: Locality

)