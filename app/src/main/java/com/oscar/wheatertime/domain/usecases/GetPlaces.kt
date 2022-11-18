package com.oscar.wheatertime.domain.usecases

import com.oscar.wheatertime.domain.repositories.PlaceRepository

class GetPlaces(private val repository: PlaceRepository) {
    var search: String = ""
    suspend operator fun invoke() = repository.getPlace(search)
}