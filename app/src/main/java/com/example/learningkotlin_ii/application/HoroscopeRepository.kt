package com.example.learningkotlin_ii.application

import com.example.learningkotlin_ii.domain.model.HoroscopePrediction

interface HoroscopeRepository {
    suspend fun getHoroscopePrediction(sign: String): HoroscopePrediction?
}