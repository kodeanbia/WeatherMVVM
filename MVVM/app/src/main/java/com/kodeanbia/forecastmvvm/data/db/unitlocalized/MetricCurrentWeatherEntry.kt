package com.kodeanbia.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

data class MetricCurrentWeatherEntry(
    @ColumnInfo(name = "temperature")
    override val temperature: Int,
    @ColumnInfo(name = "temperature")
    override val conditionText: String,
    @ColumnInfo(name = "weather_icons")
    override val conditionIconUrl: String,
    @ColumnInfo(name = "wind_speed")
    override val windSpeed: Int,
    @ColumnInfo(name = "wind_dir")
    override val windDirection: String,
    @ColumnInfo(name = "precip")
    override val precipitationVolume: Int,
    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Int,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Int
): UnitSpecificCurrentWeatherEntry