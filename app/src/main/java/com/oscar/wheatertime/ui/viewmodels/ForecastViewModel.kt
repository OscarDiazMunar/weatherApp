package com.oscar.wheatertime.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.wheatertime.domain.usecases.GetForecast
import com.oscar.wheatertime.ui.models.forecast.MainForecastUiModel
import com.oscar.wheatertime.ui.models.forecast.mapping.Mapping
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ForecastViewModel(
    private val getForecast: GetForecast
): ViewModel() {
    private var _state = MutableLiveData<MainForecastUiModel>()
    val state: LiveData<MainForecastUiModel> = _state

    private var fetchJob: Job? = null

    private fun forecast(name: String){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch() {
            getForecast.name = name
            val forecast = getForecast()
            val mappinForecast = Mapping(forecast)
            _state.postValue(mappinForecast.mapping())
        }
    }

    fun getForecast(name: String){
        forecast(name)
    }
}