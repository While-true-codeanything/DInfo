package com.example.example

import com.google.gson.annotations.SerializedName


data class Next1Hours(

    @SerializedName("summary") var summary: Summary,
    @SerializedName("details") var details: Details

)