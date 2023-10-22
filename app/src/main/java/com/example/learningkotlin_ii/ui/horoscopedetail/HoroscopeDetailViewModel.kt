package com.example.learningkotlin_ii.ui.horoscopedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningkotlin_ii.application.usecase.GetHoroscopePredictionUseCase
import com.example.learningkotlin_ii.domain.model.HoroscopePrediction
import com.example.learningkotlin_ii.domain.model.Zodiac
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(
    private val getHoroscopePredictionUseCase: GetHoroscopePredictionUseCase
): ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state
    fun getHoroscopePrediction(zodiac: Zodiac) {
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) {
                getHoroscopePredictionUseCase(zodiac.name)
            }
            if (result == null) {
                _state.value = HoroscopeDetailState.Error("Unexpected error")
                return@launch
            }
            _state.value = HoroscopeDetailState.Success(result)
        }
    }
}