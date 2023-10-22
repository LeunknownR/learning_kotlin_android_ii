package com.example.learningkotlin_ii.domain.model

import com.example.learningkotlin_ii.R

sealed class HoroscopeData(val img: Int, val name: Int, val zodiac: Zodiac) {
    data object Aries: HoroscopeData(R.drawable.aries, R.string.aries, Zodiac.Aries)
    data object Taurus: HoroscopeData(R.drawable.tauro, R.string.taurus, Zodiac.Taurus)
    data object Gemini: HoroscopeData(R.drawable.geminis, R.string.gemini, Zodiac.Gemini)
    data object Cancer: HoroscopeData(R.drawable.cancer, R.string.cancer, Zodiac.Cancer)
    data object Leo: HoroscopeData(R.drawable.leo, R.string.leo, Zodiac.Leo)
    data object Virgo: HoroscopeData(R.drawable.virgo, R.string.virgo, Zodiac.Virgo)
    data object Libra: HoroscopeData(R.drawable.libra, R.string.libra, Zodiac.Libra)
    data object Scorpio: HoroscopeData(R.drawable.escorpio, R.string.scorpio, Zodiac.Scorpio)
    data object Sagittarius: HoroscopeData(R.drawable.sagitario, R.string.sagittarius, Zodiac.Sagittarius)
    data object Capricorn: HoroscopeData(R.drawable.capricornio, R.string.capricorn, Zodiac.Capricorn)
    data object Aquarius: HoroscopeData(R.drawable.aquario, R.string.aquarius, Zodiac.Aquarius)
    data object Pisces: HoroscopeData(R.drawable.piscis, R.string.pisces, Zodiac.Pisces)
}
