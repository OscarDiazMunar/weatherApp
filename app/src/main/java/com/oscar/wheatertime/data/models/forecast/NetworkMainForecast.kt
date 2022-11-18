package com.oscar.wheatertime.data.models.forecast

import com.google.gson.annotations.SerializedName
import com.oscar.wheatertime.domain.entities.forecast.Forecast
import com.oscar.wheatertime.domain.entities.forecast.MainForecast

data class NetworkMainForecast(
    @SerializedName("forecast")override val forecast: NetworkForecast
): MainForecast