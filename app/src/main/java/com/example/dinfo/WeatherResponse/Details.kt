package com.example.example

import com.google.gson.annotations.SerializedName


data class Details(

    @SerializedName("air_pressure_at_sea_level") var airPressureAtSeaLevel: Double,
    @SerializedName("air_temperature") var airTemperature: Double,
    @SerializedName("cloud_area_fraction") var cloudAreaFraction: Double,
    @SerializedName("precipitation_amount") var precipitationAmount: Double,
    @SerializedName("relative_humidity") var relativeHumidity: Double,
    @SerializedName("wind_from_direction") var windFromDirection: Double,
    @SerializedName("wind_speed") var windSpeed: Double

)