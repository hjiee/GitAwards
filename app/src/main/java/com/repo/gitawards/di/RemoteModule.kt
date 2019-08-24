package com.repo.gitawards.di

import com.repo.gitawards.data.GithubRepository
import org.koin.dsl.module

val remoteModule = module {
    single { GithubRepository(get()) }
}