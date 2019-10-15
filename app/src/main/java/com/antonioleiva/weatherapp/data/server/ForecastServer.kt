package com.antonioleiva.weatherapp.data.server

import com.antonioleiva.weatherapp.data.db.DayForecastTable
import com.antonioleiva.weatherapp.data.db.ForecastDb
import com.antonioleiva.weatherapp.domain.datasource.ForecastDataSource
import com.antonioleiva.weatherapp.domain.model.ForecastList
/**
 * @author conanaiflj
 * @date 2019/3/14 0014
 * @description:
 */
class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()
}