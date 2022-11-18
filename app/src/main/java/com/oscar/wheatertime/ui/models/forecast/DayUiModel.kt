package com.oscar.wheatertime.ui.models.forecast

data class DayUiModel(
    val maxtempC: Double,
    val mintempC: Double,
    val conditionUiModel: ConditionUiModel
)
