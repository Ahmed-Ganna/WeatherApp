package com.ganna.weatherapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ganna.weatherapp.R
import com.ganna.weatherapp.data.RequestForecastCommand
import com.ganna.weatherapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Anko extension function
        val forecastList: RecyclerView = find(R.id.forecast_list)


        forecastList.layoutManager = LinearLayoutManager(this)


        doAsync {
            val result = RequestForecastCommand("94043").execute()

            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }

}
