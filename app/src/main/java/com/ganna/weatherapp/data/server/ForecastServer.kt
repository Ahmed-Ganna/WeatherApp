package com.ganna.weatherapp.data.server

import com.ganna.weatherapp.data.db.ForecastDb
import com.ganna.weatherapp.domain.model.ForecastList
import com.ganna.weatherapp.mappers.ServerDataMapper
import com.ganna.weatherapp.provider.ForecastDataSource

class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

override fun requestForecastByZipCode(zipCode: Long, date: Long):
 ForecastList? {
 val result = ForecastByZipCodeRequest(zipCode).execute()
 val converted = dataMapper.convertToDomain(zipCode, result)
 forecastDb.saveForecast(converted)
 return forecastDb.requestForecastByZipCode(zipCode, date)
}

}