package com.oscar.wheatertime.data.datasources.implementation.client

import com.oscar.wheatertime.data.models.NetworkPlace
import com.oscar.wheatertime.data.models.forecast.NetworkMainForecast
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v1/search.json?key= de5553176da64306b86153651221606")
    suspend fun fetchList(@Query("q") q: String): List<NetworkPlace>

    @GET("v1/forecast.json?key= de5553176da64306b86153651221606&days=3")
    suspend fun getForecast(@Query("q") q: String): NetworkMainForecast

}