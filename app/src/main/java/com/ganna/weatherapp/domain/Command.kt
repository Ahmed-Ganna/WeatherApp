package com.ganna.weatherapp.domain

interface Command<out T> {
    fun execute(): T
}