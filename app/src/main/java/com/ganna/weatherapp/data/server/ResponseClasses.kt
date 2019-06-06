package com.ganna.weatherapp.data.server

data class Weather(val id:Long, val name:String, val description:String, val icon:String)

data class Temperature(val min:Float , val max:Float , val day:Float , val night:Float , val morn:Float , val even:Float)

data class Forecast(val dt:Long, val temp: Temperature, val pressure:Float, val humidity:Int, val weather :List<Weather>
                    , val speed:Float, val deg:Int, val clouds:Int)

data class Coordinates(val lon:Float,val lat:Float)

data class City(val id:Long, val  name:String, val coord: Coordinates, val country:String, val populations:Int)

data class ForecastResult(val city: City, val code:String, val message:Float, val cnt:Int, val list:List<Forecast>)