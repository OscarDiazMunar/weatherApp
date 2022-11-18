package com.oscar.wheatertime.data.datasources.implementation.client

import com.oscar.wheatertime.data.models.NetworkPlace
import com.oscar.wheatertime.core.data.Result
import com.oscar.wheatertime.data.models.forecast.NetworkMainForecast

class PlaceClient(private val service: PlaceService) {
    suspend fun fetchList(search: String): Result<List<NetworkPlace>> = try {
        Result.success(service.fetchList(search))
    }catch (exception: Throwable){
        Result.failure(ServiceError(exception.message.orEmpty()))
    }

    suspend fun getForecast(name: String): Result<NetworkMainForecast> = try {
        Result.success(service.getForecast(name))
    }catch (exception: Throwable){
        Result.failure(ServiceError(exception.message.orEmpty()))
    }
}