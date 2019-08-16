package com.repo.gitawards.base

import android.app.Application
import com.repo.gitawards.di.networkModule
import com.repo.gitawards.di.remoteModule
import com.repo.gitawards.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(networkModule, viewModelModule, remoteModule))
        }
    }
}