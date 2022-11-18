package com.oscar.wheatertime.data.datasources.implementation

import com.oscar.wheatertime.core.data.Failure
import com.oscar.wheatertime.core.data.Success
import com.oscar.wheatertime.data.datasources.RemoteDataSource
import com.oscar.wheatertime.data.datasources.implementation.client.PlaceClient
import com.oscar.wheatertime.domain.entities.forecast.MainForecast

internal class ServiceDataSource(private val client: PlaceClient): RemoteDataSource {
    override suspend fun getPlace(search: String) = when (val result = client.fetchList(search)) {
        is Success -> result.out
        is Failure -> emptyList()
    }

    override suspend fun getForecast(name: String): MainForecast {
        val nothing = null
        return when (val result = client.getForecast(name)) {
            is Success -> result.out
            is Failure -> nothing as MainForecast
        }
    }
}