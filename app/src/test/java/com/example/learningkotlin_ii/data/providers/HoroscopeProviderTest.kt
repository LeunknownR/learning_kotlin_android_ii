package com.example.learningkotlin_ii.data.providers

import com.example.learningkotlin_ii.ui.model.LuckyCardModel
import com.example.learningkotlin_ii.ui.provider.RandomLuckyCardProvider
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow

class HoroscopeProviderTest {
    @Test
    fun `getRandomCard function should return a random card`() {
        // Given
        val randomCardProvider = RandomLuckyCardProvider()
        // When
        var luckyCard: LuckyCardModel? = null
        // Then
        assertDoesNotThrow {
            luckyCard = randomCardProvider.getLuckyCard()
        }
    }
}