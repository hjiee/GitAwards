package com.repo.gitawards.ui.main

import com.repo.gitawards.base.BaseViewModel
import com.repo.gitawards.data.GithubRepository
import com.repo.gitawards.network.NetworkResponse

class MainViewModel(private val repository: GithubRepository) : BaseViewModel() {

//    val list = MutableLiveData<List<GithubResponse>>()

    fun getRank() {
        repository.getRank()
    }

    fun getRepository() {
//        repository.getRepository()
    }

    fun getUsers() {
        repository.getUsers()
    }

    fun <T> load() {
        repository.listAll<T> (
            success = {

            },
            failur = {

            })
    }

    fun search() {
        repository.search()
    }
}