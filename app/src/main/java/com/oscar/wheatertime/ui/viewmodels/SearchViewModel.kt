package com.oscar.wheatertime.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.wheatertime.domain.usecases.GetPlaces
import com.oscar.wheatertime.ui.models.PlaceUiModel
import com.oscar.wheatertime.ui.models.mapping.asUiModels
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getPlaces: GetPlaces
    ): ViewModel() {

    private var _state = MutableLiveData<List<PlaceUiModel>>()
    val state: LiveData<List<PlaceUiModel>> = _state

    private var fetchJob: Job? = null

    private fun places(search: String) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch() {
            getPlaces.search = search
            val places = getPlaces().asUiModels()
            _state.postValue(places)
        }
    }

    fun search(search: String){
        places(search)
    }
}