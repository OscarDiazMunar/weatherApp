package com.oscar.wheatertime.domain.entities.forecast

import com.oscar.wheatertime.data.models.forecast.NetworkForecastday

interface Forecast {
    val forecastDay: List<NetworkForecastday>
}