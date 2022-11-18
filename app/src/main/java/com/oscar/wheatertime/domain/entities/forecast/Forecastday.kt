package com.oscar.wheatertime.domain.entities.forecast

import com.oscar.wheatertime.data.models.forecast.NetworkDay

interface Forecastday {
    val date: String
    val day: NetworkDay
}