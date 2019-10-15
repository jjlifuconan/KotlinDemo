package com.antonioleiva.weatherapp.ui

import android.app.Application
import com.antonioleiva.weatherapp.extensions.DelegatesExt
import kotlin.properties.Delegates
/**
 * @author conanaiflj
 * @date 2019/3/14 0014
 * @description:
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}