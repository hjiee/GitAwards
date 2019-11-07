package com.github.gitawards.ui.github.users

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.gitawards.base.BaseViewModel
import com.github.gitawards.data.GithubRepository
import com.github.gitawards.network.model.GithubResponse

class UserViewModel(private val repository: GithubRepository) : BaseViewModel() {

    private val _githubInfo = MutableLiveData<List<GithubResponse.Items>>()
    val githubInfo: LiveData<List<GithubResponse.Items>> get() = _githubInfo

    // refresh면 true / 아니면 false
    private val _rvRefresh = MutableLiveData<Boolean>()
    val rvRefresh : LiveData<Boolean> get() = _rvRefresh.apply { false }

    // 결과값이 null이면 true, null이 아니면 false
    private val _stateIsEmpty = MutableLiveData<Boolean>()
    val stateIsEmpty: LiveData<Boolean> get() = _stateIsEmpty.apply { true }

    fun load(page : Int = 0) {
        repository.loadUser(
            type = "hjiee",
            page = page,
            success = {

            },
            failure = {

            })

    }
}