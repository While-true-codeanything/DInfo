package com.example.example

import com.google.gson.annotations.SerializedName


data class Country(

    @SerializedName("AddressLine") var AddressLine: String,
    @SerializedName("CountryNameCode") var CountryNameCode: String,
    @SerializedName("CountryName") var CountryName: String,
    @SerializedName("AdministrativeArea") var AdministrativeArea: AdministrativeArea

)