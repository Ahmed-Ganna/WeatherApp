package com.ganna.weatherapp.data

import com.ganna.weatherapp.domain.Command
import com.ganna.weatherapp.domain.model.ForecastList
import com.ganna.weatherapp.provider.ForecastProvider

class RequestForecastCommand(private val zipCode:Long,
                             val forecastProvider: ForecastProvider = ForecastProvider())
    : Command<ForecastList> {

    companion object {
         val DAYS = 7
         }

    override fun execute(): ForecastList {
         return forecastProvider.requestByZipCode(zipCode, DAYS)
         }

}