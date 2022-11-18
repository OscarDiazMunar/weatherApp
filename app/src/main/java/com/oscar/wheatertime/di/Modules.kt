package com.oscar.wheatertime.di

import com.oscar.wheatertime.core.data.service
import com.oscar.wheatertime.data.datasources.RemoteDataSource
import com.oscar.wheatertime.data.datasources.implementation.ServiceDataSource
import com.oscar.wheatertime.data.datasources.implementation.client.PlaceClient
import com.oscar.wheatertime.data.datasources.implementation.client.PlaceService
import com.oscar.wheatertime.data.repositories.PlaceImpRepository
import com.oscar.wheatertime.domain.repositories.PlaceRepository
import com.oscar.wheatertime.domain.usecases.GetForecast
import com.oscar.wheatertime.domain.usecases.GetPlaces
import com.oscar.wheatertime.ui.viewmodels.ForecastViewModel
import com.oscar.wheatertime.ui.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * presentation layer definition module
 */
val presentationModule = module {
    viewModel { SearchViewModel(getPlaces = get<GetPlaces>()) }
    viewModel { ForecastViewModel(getForecast = get<GetForecast>()) }
}
/**
 * domain layer definition module
 */
val domainModule = module {
    factory { GetPlaces(repository = get<PlaceRepository>()) }
    factory { GetForecast(repository = get<PlaceRepository>()) }
}

val dataModule = module {
    single<PlaceService> { service("https://api.weatherapi.com/") }
    single<PlaceClient> { PlaceClient(get<PlaceService>()) }
    factory<RemoteDataSource> { ServiceDataSource(client = get<PlaceClient>()) }
    factory<PlaceRepository> {
        PlaceImpRepository(remoteDataSource = get<RemoteDataSource>())
    }
}

internal val modulesDefinitions = listOf(domainModule, dataModule, presentationModule)