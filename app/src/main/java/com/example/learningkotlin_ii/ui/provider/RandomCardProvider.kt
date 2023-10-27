package com.example.learningkotlin_ii.ui.provider

import com.example.learningkotlin_ii.R
import com.example.learningkotlin_ii.ui.model.LuckyModel
import javax.inject.Inject
import kotlin.random.Random

class RandomCardProvider @Inject constructor() {
    companion object {
        val LUCKY_LIST = arrayOf<LuckyModel>(
             LuckyModel(R.drawable.card_fool, R.string.luck_0),
             LuckyModel(R.drawable.card_moon, R.string.luck_1),
             LuckyModel(R.drawable.card_hermit, R.string.luck_2),
             LuckyModel(R.drawable.card_star, R.string.luck_3),
             LuckyModel(R.drawable.card_sun, R.string.luck_4),
             LuckyModel(R.drawable.card_sword, R.string.luck_5),
             LuckyModel(R.drawable.card_chariot, R.string.luck_6),
             LuckyModel(R.drawable.card_death, R.string.luck_7),
             LuckyModel(R.drawable.card_devil, R.string.luck_8),
             LuckyModel(R.drawable.card_empress, R.string.luck_9),
             LuckyModel(R.drawable.card_hierophant, R.string.luck_10),
             LuckyModel(R.drawable.card_ace_pentacles, R.string.luck_11),
             LuckyModel(R.drawable.card_judgement, R.string.luck_12),
             LuckyModel(R.drawable.card_world, R.string.luck_13),
             LuckyModel(R.drawable.card_wheel_fortune, R.string.luck_14),
             LuckyModel(R.drawable.card_tower, R.string.luck_15),
             LuckyModel(R.drawable.card_temperance, R.string.luck_16),
             LuckyModel(R.drawable.card_strength, R.string.luck_17),
             LuckyModel(R.drawable.card_queen_wands, R.string.luck_18),
             LuckyModel(R.drawable.card_queen_swords, R.string.luck_19),
             LuckyModel(R.drawable.card_priestess, R.string.luck_20),
             LuckyModel(R.drawable.card_nine_wands, R.string.luck_21),
             LuckyModel(R.drawable.card_page_wands, R.string.luck_22),
             LuckyModel(R.drawable.card_magician, R.string.luck_23),
             LuckyModel(R.drawable.card_king_pentacles, R.string.luck_24),
             LuckyModel(R.drawable.card_two_pentacles, R.string.luck_25),
             LuckyModel(R.drawable.card_queen_pentacles, R.string.luck_26),
             LuckyModel(R.drawable.card_justice, R.string.luck_27),
             LuckyModel(R.drawable.card_king_swords, R.string.luck_28),
             LuckyModel(R.drawable.card_king_wands, R.string.luck_29),
             LuckyModel(R.drawable.card_king_cups, R.string.luck_30),
             LuckyModel(R.drawable.card_king_pentacles, R.string.luck_31),
        )
    }
    fun getLucky(): LuckyModel {
         return LUCKY_LIST[Random.nextInt(0, LUCKY_LIST.size)]
    }
}