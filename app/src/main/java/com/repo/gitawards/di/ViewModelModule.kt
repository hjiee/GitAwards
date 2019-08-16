package com.repo.gitawards.di

import com.repo.gitawards.data.GithubRepository
import com.repo.gitawards.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}