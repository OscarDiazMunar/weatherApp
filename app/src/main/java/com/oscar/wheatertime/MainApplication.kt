package com.oscar.wheatertime

import android.app.Application
import com.oscar.wheatertime.di.AppConfiguration

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppConfiguration.init(app = this)
    }
}