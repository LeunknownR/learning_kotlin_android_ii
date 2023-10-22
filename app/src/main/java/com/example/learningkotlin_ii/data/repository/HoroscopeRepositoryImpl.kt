package com.example.learningkotlin_ii.data.repository

import android.util.Log
import com.example.learningkotlin_ii.application.HoroscopeRepository
import com.example.learningkotlin_ii.data.network.HoroscopeApiService
import com.example.learningkotlin_ii.domain.model.HoroscopePrediction
import javax.inject.Inject

class HoroscopeRepositoryImpl @Inject constructor(
    private val horoscopeApiService: HoroscopeApiService
): HoroscopeRepository {
    override suspend fun getHoroscopePrediction(sign: String): HoroscopePrediction? {
        runCatching { horoscopeApiService.getHoroscope(sign) }
            .onSuccess {
                return it.toDomain()
            }
            .onFailure {
                Log.i("manuel", "Error ${it.message}")
            }
        return null
    }
}