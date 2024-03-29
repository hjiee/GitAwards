package com.github.gitawards.di

import com.github.gitawards.BuildConfig
import com.github.gitawards.network.api.GithubApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
            .build()
    }

    single<Converter.Factory> {
        GsonConverterFactory.create()
    }

    single<CallAdapter.Factory> {
        RxJava2CallAdapterFactory.create()
    }

    single {
        Retrofit
            .Builder()
            .client(get())
            .baseUrl(BuildConfig.BASEURL)
            .addConverterFactory(get())
            .addCallAdapterFactory(get())
            .build()
            .create(GithubApi::class.java)
    }
}