package com.example.learningkotlin_ii.data.network.response

import com.example.learningkotlin_ii.domain.model.HoroscopePrediction
import com.google.gson.annotations.SerializedName

data class HoroscopePredictionResponse(
    @SerializedName("sign") val sign: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("date") val date: String
) {
    fun toDomain(): HoroscopePrediction {
        return HoroscopePrediction(sign = sign, horoscope = horoscope)
    }
}
