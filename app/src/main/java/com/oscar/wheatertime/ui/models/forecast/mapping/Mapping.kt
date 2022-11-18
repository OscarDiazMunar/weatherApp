package com.oscar.wheatertime.ui.models.forecast.mapping

import com.oscar.wheatertime.domain.entities.forecast.MainForecast
import com.oscar.wheatertime.ui.models.forecast.MainForecastUiModel

class Mapping(val networkMainForecast: MainForecast){
    fun mapping(): MainForecastUiModel {

        var mainForecastUiModel = MainForecastUiModel(networkMainForecast.forecast)
        return mainForecastUiModel
    }
}

