package com.oscar.wheatertime.data.models.forecast

import com.google.gson.annotations.SerializedName
import com.oscar.wheatertime.domain.entities.forecast.Condition
import com.oscar.wheatertime.domain.entities.forecast.Day

data class NetworkDay(
    @SerializedName("maxtemp_c")override val maxtempC: Double,
    @SerializedName("mintemp_")override val mintempC: Double,
    @SerializedName("condition")override val condition: NetworkCondition
): Day