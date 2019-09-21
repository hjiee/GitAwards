package com.repo.gitawards.base

import android.app.Application
import com.airbnb.lottie.LottieAnimationView
import com.repo.gitawards.R
import com.repo.gitawards.di.networkModule
import com.repo.gitawards.di.remoteModule
import com.repo.gitawards.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(networkModule, viewModelModule, remoteModule))
        }
    }

    companion object {
        private val application = BaseApplication()
        fun getInstance() : BaseApplication {
            return application
        }
    }

    fun progressOn(lottie : LottieAnimationView) {
        lottie.setAnimation("loading.json")
        lottie.playAnimation()

    }

    fun progressOff(lottie: LottieAnimationView) {
        lottie.cancelAnimation()
    }
}