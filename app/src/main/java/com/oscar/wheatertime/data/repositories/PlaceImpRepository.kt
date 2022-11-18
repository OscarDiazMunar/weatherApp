package com.oscar.wheatertime.data.repositories

import com.oscar.wheatertime.data.datasources.RemoteDataSource
import com.oscar.wheatertime.domain.entities.Place
import com.oscar.wheatertime.domain.entities.forecast.MainForecast
import com.oscar.wheatertime.domain.repositories.PlaceRepository

internal class PlaceImpRepository(
    private val remoteDataSource: RemoteDataSource
): PlaceRepository {
    override suspend fun getPlace(search: String): List<Place> {
        return remoteDataSource.getPlace(search)
    }

    override suspend fun getForecast(name: String): MainForecast {
        return remoteDataSource.getForecast(name)
    }
}