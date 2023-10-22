package com.example.learningkotlin_ii.ui.horoscopedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.learningkotlin_ii.R
import com.example.learningkotlin_ii.databinding.ActivityHoroscopeDetailBinding
import com.example.learningkotlin_ii.domain.model.HoroscopePrediction
import com.example.learningkotlin_ii.domain.model.Zodiac
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val args: HoroscopeDetailActivityArgs by navArgs()
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()
    companion object {
        private val HOROSCOPE_DETAIL_IMAGES: Map<Zodiac, Int> = mapOf(
            Zodiac.Aries to R.drawable.detail_aries,
            Zodiac.Taurus to R.drawable.detail_taurus,
            Zodiac.Gemini to R.drawable.detail_gemini,
            Zodiac.Cancer to R.drawable.detail_cancer,
            Zodiac.Leo to R.drawable.detail_leo,
            Zodiac.Virgo to R.drawable.detail_virgo,
            Zodiac.Libra to R.drawable.detail_libra,
            Zodiac.Scorpio to R.drawable.detail_scorpio,
            Zodiac.Sagittarius to R.drawable.detail_sagittarius,
            Zodiac.Capricorn to R.drawable.detail_capricorn,
            Zodiac.Aquarius to R.drawable.detail_aquarius,
            Zodiac.Pisces to R.drawable.detail_pisces
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }
    private fun setup() {
        horoscopeDetailViewModel.getHoroscopePrediction(args.zodiac)
        onHoroscopeDetailViewModelChanges()
    }
    private fun onHoroscopeDetailViewModelChanges() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    manageState(it)
                }
            }
        }
    }
    private fun manageState(state: HoroscopeDetailState) {
        when (state) {
            HoroscopeDetailState.Loading -> loadingStateResponse()
            is HoroscopeDetailState.Success -> successStateResponse(state.horoscopePrediction)
            is HoroscopeDetailState.Error -> errorStateResponse()
        }
    }
    private fun loadingStateResponse() {
        showProgressBar()
    }
    private fun showProgressBar() {
        binding.progressBar.isVisible = true
    }
    private fun hideProgressBar() {
        binding.progressBar.isVisible = false
    }
    private fun successStateResponse(horoscopePrediction: HoroscopePrediction) {
        binding.tvTitle.text = horoscopePrediction.sign
        binding.tvBody.text = horoscopePrediction.horoscope
        binding.ivZodiac.setImageResource(HOROSCOPE_DETAIL_IMAGES[args.zodiac]!!)
        hideProgressBar()
    }
    private fun errorStateResponse() {
        hideProgressBar()
    }
}