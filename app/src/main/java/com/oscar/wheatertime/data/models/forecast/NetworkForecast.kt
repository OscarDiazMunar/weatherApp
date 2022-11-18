package com.oscar.wheatertime.data.models.forecast

import com.google.gson.annotations.SerializedName
import com.oscar.wheatertime.domain.entities.forecast.Day
import com.oscar.wheatertime.domain.entities.forecast.Forecast
import com.oscar.wheatertime.domain.entities.forecast.Forecastday

data class NetworkForecast (
    @SerializedName("forecastday")override val forecastDay: List<NetworkForecastday>
): Forecast
