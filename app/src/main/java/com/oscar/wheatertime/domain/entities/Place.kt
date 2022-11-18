package com.oscar.wheatertime.domain.entities

interface Place {
    val id: Long
    val name: String
    val region: String
    val country: String
    val lat: Double
    val lon: Double
    val url: String
}