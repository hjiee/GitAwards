package com.github.gitawards.base

import android.app.Application
import com.airbnb.lottie.LottieAnimationView
import com.github.gitawards.R
import com.github.gitawards.di.networkModule
import com.github.gitawards.di.remoteModule
import com.github.gitawards.di.viewModelModule
import com.google.android.gms.ads.MobileAds
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {


    val remoteConfig by lazy {
        FirebaseRemoteConfig.getInstance()
            .apply {
                setConfigSettingsAsync(
                    FirebaseRemoteConfigSettings.Builder()
                        .setMinimumFetchIntervalInSeconds(3600)
                        .build()
                )
            }
    }

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(networkModule, viewModelModule, remoteModule))
        }

        MobileAds.initialize(applicationContext, getString(R.string.ads_id))


    }

    companion object {
        private val application = BaseApplication()
        fun getInstance(): BaseApplication {
            return application
        }

    }

    fun progressOn(lottie: LottieAnimationView) {
        lottie.setAnimation("loading.json")
        lottie.playAnimation()

    }

    fun progressOff(lottie: LottieAnimationView) {
        lottie.cancelAnimation()
    }
}