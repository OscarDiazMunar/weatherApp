package com.oscar.wheatertime.ui.models.mapping

import com.oscar.wheatertime.domain.entities.Place
import com.oscar.wheatertime.ui.models.PlaceUiModel

internal fun List<Place>.asUiModels() = map { it.asUiModel() }

internal fun Place.asUiModel() =
    PlaceUiModel(
         id = id,
         name = name,
         region = region,
         country = country,
         lat = lat,
         lon = lon,
         url = url
    )