package com.example.learningkotlin_ii.data.providers

import com.example.learningkotlin_ii.domain.model.HoroscopeData
import com.example.learningkotlin_ii.domain.model.Zodiac
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeData> {
        return listOf(
            HoroscopeData.Aries,
            HoroscopeData.Taurus,
            HoroscopeData.Gemini,
            HoroscopeData.Cancer,
            HoroscopeData.Leo,
            HoroscopeData.Virgo,
            HoroscopeData.Libra,
            HoroscopeData.Scorpio,
            HoroscopeData.Sagittarius,
            HoroscopeData.Capricorn,
            HoroscopeData.Aquarius,
            HoroscopeData.Pisces
        )
    }
}