package com.repo.gitawards.ui.main

import androidx.lifecycle.MutableLiveData
import com.repo.gitawards.base.BaseViewModel
import com.repo.gitawards.data.GithubRepository
import com.repo.gitawards.network.model.GithubResponse

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