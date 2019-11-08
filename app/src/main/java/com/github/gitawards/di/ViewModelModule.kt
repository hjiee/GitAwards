package com.github.gitawards.di

import com.github.gitawards.ui.main.MainViewModel
import com.github.gitawards.ui.github.language.LanguageViewModel
import com.github.gitawards.ui.github.repositories.RepositoryViewModel
import com.github.gitawards.ui.github.users.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { LanguageViewModel(get()) }
    viewModel { RepositoryViewModel(get()) }
    viewModel { UserViewModel(get()) }
}