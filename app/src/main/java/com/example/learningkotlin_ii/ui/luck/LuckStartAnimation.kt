package com.example.learningkotlin_ii.ui.luck

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.example.learningkotlin_ii.R
import com.example.learningkotlin_ii.databinding.FragmentLuckBinding
import com.example.learningkotlin_ii.ui.core.listener.OnSwipeTouchListener
import java.util.Random

class LuckStartAnimation(binding: FragmentLuckBinding, private val end: () -> Unit) {
    private val ivRoulette: ImageView
    private val ivCardReverse: ImageView
    private val predictionView: ConstraintLayout
    private val preview: ConstraintLayout
    init {
        ivRoulette = binding.ivRoulette
        ivCardReverse = binding.ivCardReverse
        preview = binding.preview
        predictionView = binding.predictionView
    }
    @SuppressLint("ClickableViewAccessibility")
    fun setup() {
        ivRoulette.setOnTouchListener(
                object : OnSwipeTouchListener(ivRoulette.context) {
                    override fun onSwipeRight() {
                        spinIvRoulette()
                    }
                    override fun onSwipeLeft() {
                        spinIvRoulette(true)
                    }
                }
        )
    }
    private fun spinIvRoulette(isLeft: Boolean = false) {
        val random = Random()
        val degrees = (random.nextInt(1440) + 360) * (if (isLeft) -1 else 1)
        val animator = ObjectAnimator.ofFloat(ivRoulette, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideUpIvCardReverse() }
        animator.start()
    }
    private fun slideUpIvCardReverse() {
        val animator =
                AnimationUtils.loadAnimation(
                        ivRoulette.context,
                        R.anim.luck_iv_card_reverse_slide_up
                )
        animator.setAnimationListener(
                object : Animation.AnimationListener {
                    override fun onAnimationStart(p0: Animation?) {
                        ivCardReverse.isVisible = true
                    }
                    override fun onAnimationEnd(p0: Animation?) {
                        growIvCardReverse()
                    }
                    override fun onAnimationRepeat(p0: Animation?) {}
                }
        )
        ivCardReverse.startAnimation(animator)
    }
    private fun growIvCardReverse() {
        val animator =
                AnimationUtils.loadAnimation(
                        ivCardReverse.context,
                        R.anim.luck_iv_card_reverse_grow
                )
        animator.setAnimationListener(
                object : Animation.AnimationListener {
                    override fun onAnimationStart(p0: Animation?) {}
                    override fun onAnimationEnd(p0: Animation?) {
                        ivCardReverse.isVisible = false
                        hidePreview()
                        showPredictionView()
                    }
                    override fun onAnimationRepeat(p0: Animation?) {}
                }
        )
        ivCardReverse.startAnimation(animator)
    }
    private fun hidePreview() {
        val animation = AlphaAnimation(1.0f, 0.0f)
        animation.duration = 200
        animation.setAnimationListener(
                object : Animation.AnimationListener {
                    override fun onAnimationRepeat(p0: Animation?) {}
                    override fun onAnimationEnd(p0: Animation?) {
                        preview.isVisible = false
                        predictionView.isVisible = true
                    }
                    override fun onAnimationStart(p0: Animation?) {
                        end()
                    }
                }
        )
        preview.startAnimation(animation)
    }
    private fun showPredictionView() {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 1000
        predictionView.startAnimation(animation)
    }
}
