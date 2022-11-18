package com.oscar.wheatertime.data.datasources.implementation.client

import com.oscar.wheatertime.core.data.AppException

data class ServiceError(val error: String) : AppException(error)
