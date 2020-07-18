package com.kodeanbia.forecastmvvm.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kodeanbia.forecastmvvm.data.db.entity.network.response.CurrentWeatherRespone
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "53314a6afa02369c821fe076f3dd13cc"

//http://api.weatherstack.com/current?access_key=53314a6afa02369c821fe076f3dd13cc&query=London&lang=en

interface ApiWeatherApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location:String,
        @Query("lang") languageCode:String = "en"
    ):Deferred<CurrentWeatherRespone>

    companion object{
        operator fun invoke():ApiWeatherApiService{
            val requestInterceptor = Interceptor {chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiWeatherApiService::class.java)
        }
    }
}