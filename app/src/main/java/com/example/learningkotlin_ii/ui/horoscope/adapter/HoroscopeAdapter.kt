package com.example.learningkotlin_ii.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningkotlin_ii.R
import com.example.learningkotlin_ii.domain.model.HoroscopeData

class HoroscopeAdapter(private val selectHoroscope: (horoscope: HoroscopeData) -> Unit):
    RecyclerView.Adapter<HoroscopeViewHolder>() {
    var horoscopes: List<HoroscopeData> = emptyList()
        set(newHoroscopes) {
            field = newHoroscopes
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false),
            selectHoroscope
        )
    }
    override fun getItemCount(): Int = horoscopes.size
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopes[position])
    }
}