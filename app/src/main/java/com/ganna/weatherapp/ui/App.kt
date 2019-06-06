package com.ganna.weatherapp.ui

import android.app.Application
import com.ganna.weatherapp.extensions.DelegatesExt

class App: Application() {

    companion object {
         var instance : App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}