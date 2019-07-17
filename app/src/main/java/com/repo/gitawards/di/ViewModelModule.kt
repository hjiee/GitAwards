package com.repo.gitawards.di

import com.repo.gitawards.base.BaseViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        BaseViewModel()
    }
}