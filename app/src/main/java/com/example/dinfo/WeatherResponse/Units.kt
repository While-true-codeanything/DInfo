package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Units (

   @SerializedName("air_pressure_at_sea_level") var airPressureAtSeaLevel : String,
   @SerializedName("air_temperature") var airTemperature : String,
   @SerializedName("cloud_area_fraction") var cloudAreaFraction : String,
   @SerializedName("precipitation_amount") var precipitationAmount : String,
   @SerializedName("relative_humidity") var relativeHumidity : String,
   @SerializedName("wind_from_direction") var windFromDirection : String,
   @SerializedName("wind_speed") var windSpeed : String

)