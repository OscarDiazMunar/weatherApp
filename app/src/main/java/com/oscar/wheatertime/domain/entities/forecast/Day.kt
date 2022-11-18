package com.oscar.wheatertime.domain.entities.forecast

import com.oscar.wheatertime.data.models.forecast.NetworkCondition

interface Day {
    val maxtempC: Double
    val mintempC: Double
    val condition: NetworkCondition
}