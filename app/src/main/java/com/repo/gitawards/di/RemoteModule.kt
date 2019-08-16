package com.repo.gitawards.di

import com.repo.gitawards.data.GithubRepositoryImpl
import com.repo.gitawards.data.GithubRepository
import com.repo.gitawards.network.api.GithubApi
import com.repo.gitawards.network.model.GithubResponse
import org.koin.dsl.module

val remoteModule = module {
    single<GithubRepository> { GithubRepositoryImpl() }
}