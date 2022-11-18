package com.oscar.wheatertime.data.datasources

import com.oscar.wheatertime.domain.entities.Place
import com.oscar.wheatertime.domain.entities.forecast.MainForecast

interface RemoteDataSource {
    suspend fun getPlace(search: String): List<Place>
    suspend fun getForecast(name: String): MainForecast
}