package com.kodeanbia.forecastmvvm.data.db.entity.network.response

import com.google.gson.annotations.SerializedName
import com.kodeanbia.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.kodeanbia.forecastmvvm.data.db.entity.Location
import com.kodeanbia.forecastmvvm.data.db.entity.Request


data class CurrentWeatherRespone(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)