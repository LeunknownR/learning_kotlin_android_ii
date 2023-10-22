package com.example.learningkotlin_ii.ui.horoscopedetail

import com.example.learningkotlin_ii.domain.model.HoroscopePrediction

sealed class HoroscopeDetailState {
    data object Loading: HoroscopeDetailState()
    data class Success(val horoscopePrediction: HoroscopePrediction): HoroscopeDetailState()
    data class Error(val error: String): HoroscopeDetailState()
}