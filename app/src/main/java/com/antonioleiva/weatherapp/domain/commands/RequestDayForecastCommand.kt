package com.antonioleiva.weatherapp.domain.commands

import com.antonioleiva.weatherapp.domain.datasource.ForecastProvider
import com.antonioleiva.weatherapp.domain.model.Forecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
/**
 * @author conanaiflj
 * @date 2019/3/14 0014
 * @description:
 */
class RequestDayForecastCommand(
        val id: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override suspend fun execute() = withContext(Dispatchers.IO) {
        forecastProvider.requestForecast(id)
    }
}