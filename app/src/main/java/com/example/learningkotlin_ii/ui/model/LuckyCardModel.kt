package com.example.learningkotlin_ii.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyCardModel(
    @DrawableRes val image: Int,
    @StringRes val text: Int
)
