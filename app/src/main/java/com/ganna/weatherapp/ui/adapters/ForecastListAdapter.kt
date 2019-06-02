package com.ganna.weatherapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ganna.weatherapp.R
import com.ganna.weatherapp.domain.model.Forecast
import com.ganna.weatherapp.domain.model.ForecastList
import com.ganna.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListAdapter(val weekForecast : ForecastList,val itemClick: (Forecast)-> Unit): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx) .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view,itemClick)
    }

    override fun getItemCount(): Int  = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }


    class ViewHolder( view : View ,val itemClick: (Forecast)-> Unit):RecyclerView.ViewHolder(view){


        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = forecast.date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }

}