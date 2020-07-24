package com.example.example

import com.google.gson.annotations.SerializedName


data class GeoObjectCollection(

    @SerializedName("metaDataProperty") var metaDataProperty: MetaDataProperty,
    @SerializedName("featureMember") var featureMember: List<FeatureMember>

)