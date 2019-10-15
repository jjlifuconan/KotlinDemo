package com.antonioleiva.weatherapp.ui.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.antonioleiva.weatherapp.R
import com.antonioleiva.weatherapp.domain.commands.RequestForecastCommand
import com.antonioleiva.weatherapp.extensions.DelegatesExt
import com.antonioleiva.weatherapp.extensions.Test
import com.antonioleiva.weatherapp.extensions.setPathAnimatorDefaultListener
import com.antonioleiva.weatherapp.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import java.nio.file.Files.find
/**
 * @author conanaiflj
 * @date 2019/3/14 0014
 * @description:
 */
class MainActivity : CoroutineScopeActivity(), ToolbarManager {

    private val zipCode: Long by DelegatesExt.preference(this, SettingsActivity.ZIP_CODE,
            SettingsActivity.DEFAULT_ZIP)
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)


        setPathAnimatorDefaultListener {
            animationEnd {
//                asyncText.showFillColorText()
            }
            animationStart{

            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() = launch {
        val result = RequestForecastCommand(zipCode).execute()
        val list = result.dailyForecast as MutableList
        list.flatMap { listOf(it,it) }
        val adapter = ForecastListAdapter(result) {
            startActivity<DetailActivity>(DetailActivity.ID to it.id,
                    DetailActivity.CITY_NAME to result.city)
        }
        forecastList.adapter = adapter
        toolbarTitle = "${result.city} (${result.country})"
    }
}
