package com.oscar.wheatertime.domain.repositories

import com.oscar.wheatertime.domain.entities.Place
import com.oscar.wheatertime.domain.entities.forecast.MainForecast

interface PlaceRepository {
    suspend fun getPlace(search: String): List<Place>
    suspend fun getForecast(name: String): MainForecast
}