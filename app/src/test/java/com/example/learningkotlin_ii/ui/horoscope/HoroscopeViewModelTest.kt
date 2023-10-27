package com.example.learningkotlin_ii.ui.horoscope

import com.example.learningkotlin_ii.data.providers.HoroscopeProvider
import com.example.learningkotlin_ii.motherobject.HoroscopeMotherObject
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest {
    @MockK
    private lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewModel is created then horoscopes are filled`() {
        every { horoscopeProvider.getHoroscopes() } returns HoroscopeMotherObject.getHoroscopeDataList()
        viewModel = HoroscopeViewModel(horoscopeProvider)
        val horoscopes = viewModel.horoscopes.value
        assertTrue(horoscopes.isNotEmpty())
    }
}