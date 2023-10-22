package com.example.learningkotlin_ii.data.network

import com.example.learningkotlin_ii.data.network.response.HoroscopePredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {
    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String): HoroscopePredictionResponse
}