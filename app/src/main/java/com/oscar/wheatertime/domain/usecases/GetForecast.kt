package com.oscar.wheatertime.domain.usecases

import com.oscar.wheatertime.domain.repositories.PlaceRepository

class GetForecast(private val repository: PlaceRepository) {
    var name: String = ""
    suspend operator fun invoke() = repository.getForecast(name)
}