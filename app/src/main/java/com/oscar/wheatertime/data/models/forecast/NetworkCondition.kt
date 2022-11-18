package com.oscar.wheatertime.data.models.forecast

import com.google.gson.annotations.SerializedName
import com.oscar.wheatertime.domain.entities.forecast.Condition

data class NetworkCondition(
    @SerializedName("icon")override val icon: String
): Condition
