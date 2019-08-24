package com.repo.gitawards.ui.main

import com.repo.gitawards.base.BaseViewModel
import com.repo.gitawards.data.GithubRepository

class MainViewModel(private val repository: GithubRepository) : BaseViewModel() {

//    val list = MutableLiveData<List<GithubResponse>>()

    fun getRank() {
        repository.getRank()
    }

    fun getRepository() {
        repository.getRepository()
    }

    fun getUsers() {
        repository.getUsers()
    }
}