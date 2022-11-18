package com.oscar.wheatertime.domain.entities.forecast

import com.oscar.wheatertime.data.models.forecast.NetworkForecast

interface MainForecast {
    val forecast: NetworkForecast
}