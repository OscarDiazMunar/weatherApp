package com.oscar.wheatertime.ui.models

data class PlaceUiModel(
    val id: Long,
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val url: String
)