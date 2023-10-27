package com.example.learningkotlin_ii.ui.provider

import com.example.learningkotlin_ii.R
import com.example.learningkotlin_ii.ui.model.LuckyCardModel
import javax.inject.Inject
import kotlin.random.Random

class RandomLuckyCardProvider @Inject constructor() {
    companion object {
        val LUCKY_LIST = arrayOf<LuckyCardModel>(
             LuckyCardModel(R.drawable.card_fool, R.string.luck_0),
             LuckyCardModel(R.drawable.card_moon, R.string.luck_1),
             LuckyCardModel(R.drawable.card_hermit, R.string.luck_2),
             LuckyCardModel(R.drawable.card_star, R.string.luck_3),
             LuckyCardModel(R.drawable.card_sun, R.string.luck_4),
             LuckyCardModel(R.drawable.card_sword, R.string.luck_5),
             LuckyCardModel(R.drawable.card_chariot, R.string.luck_6),
             LuckyCardModel(R.drawable.card_death, R.string.luck_7),
             LuckyCardModel(R.drawable.card_devil, R.string.luck_8),
             LuckyCardModel(R.drawable.card_empress, R.string.luck_9),
             LuckyCardModel(R.drawable.card_hierophant, R.string.luck_10),
             LuckyCardModel(R.drawable.card_ace_pentacles, R.string.luck_11),
             LuckyCardModel(R.drawable.card_judgement, R.string.luck_12),
             LuckyCardModel(R.drawable.card_world, R.string.luck_13),
             LuckyCardModel(R.drawable.card_wheel_fortune, R.string.luck_14),
             LuckyCardModel(R.drawable.card_tower, R.string.luck_15),
             LuckyCardModel(R.drawable.card_temperance, R.string.luck_16),
             LuckyCardModel(R.drawable.card_strength, R.string.luck_17),
             LuckyCardModel(R.drawable.card_queen_wands, R.string.luck_18),
             LuckyCardModel(R.drawable.card_queen_swords, R.string.luck_19),
             LuckyCardModel(R.drawable.card_priestess, R.string.luck_20),
             LuckyCardModel(R.drawable.card_nine_wands, R.string.luck_21),
             LuckyCardModel(R.drawable.card_page_wands, R.string.luck_22),
             LuckyCardModel(R.drawable.card_magician, R.string.luck_23),
             LuckyCardModel(R.drawable.card_king_pentacles, R.string.luck_24),
             LuckyCardModel(R.drawable.card_two_pentacles, R.string.luck_25),
             LuckyCardModel(R.drawable.card_queen_pentacles, R.string.luck_26),
             LuckyCardModel(R.drawable.card_justice, R.string.luck_27),
             LuckyCardModel(R.drawable.card_king_swords, R.string.luck_28),
             LuckyCardModel(R.drawable.card_king_wands, R.string.luck_29),
             LuckyCardModel(R.drawable.card_king_cups, R.string.luck_30),
             LuckyCardModel(R.drawable.card_king_pentacles, R.string.luck_31),
        )
    }
    fun getLuckyCard(): LuckyCardModel {
         return LUCKY_LIST[Random.nextInt(0, LUCKY_LIST.size)]
    }
}