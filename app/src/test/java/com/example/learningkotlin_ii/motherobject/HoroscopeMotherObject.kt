package com.example.learningkotlin_ii.motherobject

import com.example.learningkotlin_ii.data.network.response.HoroscopePredictionResponse
import com.example.learningkotlin_ii.domain.model.HoroscopeData

object HoroscopeMotherObject {
    fun getMockResponse(): HoroscopePredictionResponse {
        return HoroscopePredictionResponse("Some prediction", "Taurus")
    }
    fun getHoroscopeDataList(): List<HoroscopeData> {
        return listOf(
            HoroscopeData.Aries
        )
    }
}