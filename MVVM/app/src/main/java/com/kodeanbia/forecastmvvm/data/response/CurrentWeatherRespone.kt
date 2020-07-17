package com.kodeanbia.forecastmvvm.data.response

import com.google.gson.annotations.SerializedName


data class CurrentWeatherRespone(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)