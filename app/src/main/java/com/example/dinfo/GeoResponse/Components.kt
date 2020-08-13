package com.example.example

import com.google.gson.annotations.SerializedName


data class Components(

    @SerializedName("kind") var kind: String,
    @SerializedName("name") var name: String

)