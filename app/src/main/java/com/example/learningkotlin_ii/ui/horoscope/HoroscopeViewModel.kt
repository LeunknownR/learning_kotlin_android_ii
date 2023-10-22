package com.example.learningkotlin_ii.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.learningkotlin_ii.data.providers.HoroscopeProvider
import com.example.learningkotlin_ii.domain.model.HoroscopeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider): ViewModel() {
    private var _horoscopes = MutableStateFlow<List<HoroscopeData>>(emptyList())
    var horoscopes: StateFlow<List<HoroscopeData>> = _horoscopes
    init {
        _horoscopes.value = horoscopeProvider.getHoroscopes()
    }
}