package com.example.learningkotlin_ii.application.usecase

import com.example.learningkotlin_ii.application.HoroscopeRepository
import com.example.learningkotlin_ii.domain.model.HoroscopePrediction
import javax.inject.Inject

class GetHoroscopePredictionUseCase @Inject constructor(private val repository: HoroscopeRepository) {
    suspend operator fun invoke(sign: String): HoroscopePrediction? {
        return repository.getHoroscopePrediction(sign)
    }
}