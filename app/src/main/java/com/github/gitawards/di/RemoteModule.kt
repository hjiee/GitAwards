package com.github.gitawards.di

import com.github.gitawards.data.GithubRepository
import org.koin.dsl.module

val remoteModule = module {
    single { GithubRepository(get()) }
}