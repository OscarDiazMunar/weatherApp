package com.oscar.wheatertime.data.models

import com.google.gson.annotations.SerializedName
import com.oscar.wheatertime.domain.entities.Place

data class NetworkPlace(
    @SerializedName("id") override val id: Long = 0,
    @SerializedName("name") override val name: String = "",
    @SerializedName("region") override val region: String = "",
    @SerializedName("country") override val country: String = "",
    @SerializedName("lat") override val lat: Double = 0.0,
    @SerializedName("lon") override val lon: Double = 0.0,
    @SerializedName("url") override val url: String = ""
) : Place


