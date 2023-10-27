package com.example.learningkotlin_ii.ui.luck

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learningkotlin_ii.databinding.FragmentLuckBinding
import com.example.learningkotlin_ii.ui.provider.RandomCardProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LuckFragment : Fragment() {
    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var randomCardProvider: RandomCardProvider
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
    private fun setup() {
        LuckStartAnimation(binding) {
            fillHoroscopePrediction()
        }.apply { setup() }
    }
    private fun fillHoroscopePrediction() {
        randomCardProvider.getLucky()
            .apply {
                val horoscopePrediction = getString(text)
                binding.tvLucky.text = horoscopePrediction
                binding.ivLuckyCard.setImageResource(image)
                binding.tvShare.setOnClickListener {
                    shareHoroscopePrediction(horoscopePrediction)
                }
            }
    }
    private fun shareHoroscopePrediction(horoscopePrediction: String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Check my horoscope prediction 😱😱😱!!!:\n*$horoscopePrediction*")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}