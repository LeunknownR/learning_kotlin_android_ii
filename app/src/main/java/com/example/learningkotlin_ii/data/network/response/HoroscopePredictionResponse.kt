package com.example.learningkotlin_ii.data.network.response

import com.example.learningkotlin_ii.domain.model.HoroscopePrediction
import com.google.gson.annotations.SerializedName

data class HoroscopePredictionResponse(
    @SerializedName("sign") val sign: String,
    @SerializedName("horoscope") val horoscope: String
) {
    override fun equals(that: Any?): Boolean {
        if (that == null) return false
        if (that !is HoroscopePredictionResponse) return false
        return this.sign == that.sign && this.horoscope == that.horoscope
    }
    fun toDomain(): HoroscopePrediction {
        return HoroscopePrediction(sign = sign, horoscope = horoscope)
    }
}
