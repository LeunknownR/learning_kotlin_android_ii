package com.example.learningkotlin_ii.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.learningkotlin_ii.databinding.ItemHoroscopeBinding
import com.example.learningkotlin_ii.domain.model.HoroscopeData

class HoroscopeViewHolder(
    view: View,
    private val selectHoroscope: (horoscope: HoroscopeData) -> Unit)
: RecyclerView.ViewHolder(view) {
    private val binding: ItemHoroscopeBinding = ItemHoroscopeBinding.bind(view)
    fun render(horoscope: HoroscopeData) {
        binding.ivHoroscope.setImageResource(horoscope.img)
        binding.tvHoroscope.text = binding.tvHoroscope.context.getText(horoscope.name)
        itemView.setOnClickListener {
            rotateIvHoroscope {
                selectHoroscope(horoscope)
            }
        }
    }
    private fun rotateIvHoroscope(finish: () -> Unit) {
        binding.ivHoroscope.animate().apply {
            duration = 350
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction {
                finish()
            }
            start()
        }
    }
}