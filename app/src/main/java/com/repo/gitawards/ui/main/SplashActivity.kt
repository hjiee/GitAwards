package com.repo.gitawards.ui.main

import android.animation.Animator
import android.app.AppComponentFactory
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        },1000)

//        lottie_github.setAnimation("loading.json")
//        lottie_github.playAnimation()

//        lottie_github.addAnimatorListener(object : Animator.AnimatorListener {
//            override fun onAnimationRepeat(p0: Animator?) {
//                Log.e("Lottie","onAnimationRepeat")
//            }
//
//            override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
//                Log.e("Lottie","onAnimationEnd")
//                super.onAnimationEnd(animation, isReverse)
//            }
//
//            override fun onAnimationEnd(p0: Animator?) {
//                Log.e("Lottie","onAnimationEnd")
//            }
//
//            override fun onAnimationCancel(p0: Animator?) {
//                Log.e("Lottie","onAnimationCancel")
//            }
//
//            override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
//                Log.e("Lottie","onAnimationStart")
//                super.onAnimationStart(animation, isReverse)
//            }
//
//            override fun onAnimationStart(p0: Animator?) {
//                Log.e("Lottie","onAnimationStart")
//            }
//        })
    }
}
