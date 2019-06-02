package com.ganna.weatherapp.data

import com.ganna.weatherapp.domain.Command
import com.ganna.weatherapp.domain.model.ForecastList
import com.ganna.weatherapp.mappers.ForecastDataMapper

class RequestForecastCommand(private val zipCode:String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }


}