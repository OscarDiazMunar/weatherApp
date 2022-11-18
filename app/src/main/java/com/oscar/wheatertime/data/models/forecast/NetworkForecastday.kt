package com.oscar.wheatertime.data.models.forecast

import com.google.gson.annotations.SerializedName
import com.oscar.wheatertime.domain.entities.forecast.Day
import com.oscar.wheatertime.domain.entities.forecast.Forecastday

data class NetworkForecastday (
    @SerializedName("date")override val date: String,
    @SerializedName("day")override val day: NetworkDay
): Forecastday
