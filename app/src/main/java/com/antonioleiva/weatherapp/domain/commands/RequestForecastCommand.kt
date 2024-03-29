package com.antonioleiva.weatherapp.domain.commands

import com.antonioleiva.weatherapp.domain.datasource.ForecastProvider
import com.antonioleiva.weatherapp.domain.model.ForecastList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
/**
 * @author conanaiflj
 * @date 2019/3/14 0014
 * @description:
 */
class RequestForecastCommand(
        private val zipCode: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override suspend fun execute() = withContext(Dispatchers.IO) {
        forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}