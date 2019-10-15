package com.antonioleiva.weatherapp.domain.datasource

import com.antonioleiva.weatherapp.domain.model.Forecast
import com.antonioleiva.weatherapp.domain.model.ForecastList
/**
 * @author conanaiflj
 * @date 2019/3/14 0014
 * @description:
 */
interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}