package com.example.learningkotlin_ii.data.network.response

import com.example.learningkotlin_ii.motherobject.HoroscopeMotherObject
import io.kotlintest.shouldBe
import org.junit.Test

class HoroscopePredictionResponseTest {
    @Test
    fun `toDomain function should return the object parsed to HoroscopePrediction object`() {
        // Given
        val horoscopePredictionResponse = HoroscopeMotherObject.getMockResponse()
        // When
        val horoscopePrediction = horoscopePredictionResponse.toDomain()
        // Then
        horoscopePrediction.sign shouldBe horoscopePredictionResponse.sign
        horoscopePrediction.horoscope shouldBe horoscopePredictionResponse.horoscope
    }
}