package com.example.example

import com.google.gson.annotations.SerializedName


data class GeoObject(

    @SerializedName("metaDataProperty") var metaDataProperty: MetaDataProperty,
    @SerializedName("name") var name: String,
    @SerializedName("description") var description: String,
    @SerializedName("boundedBy") var boundedBy: BoundedBy,
    @SerializedName("Point") var Point: Point

)