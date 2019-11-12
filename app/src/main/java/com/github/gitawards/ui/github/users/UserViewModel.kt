package com.github.gitawards.ui.github.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.gitawards.base.BaseViewModel
import com.github.gitawards.data.GithubRepository
import com.github.gitawards.network.model.UserResponse
import com.github.gitawards.network.model.UserSearchResponse

class UserViewModel(private val repository: GithubRepository) : BaseViewModel() {

    private val _userInfo = MutableLiveData<List<UserResponse.Items>>()
    val userInfo: LiveData<List<UserResponse.Items>> get() = _userInfo

    private val _userInfo2 = MutableLiveData<List<UserSearchResponse>>()
    val userInfo2: LiveData<List<UserSearchResponse>> get() = _userInfo2

    // refresh면 true / 아니면 false
    private val _rvRefresh = MutableLiveData<Boolean>()
    val rvRefresh: LiveData<Boolean> get() = _rvRefresh.apply { false }

    // 결과값이 null이면 true, null이 아니면 false
    private val _stateIsEmpty = MutableLiveData<Boolean>()
    val stateIsEmpty: LiveData<Boolean> get() = _stateIsEmpty.apply { true }

    fun load(page: Int = 0) {
        repository.loadUser(
            type = "hjiee",
            page = page,
            success = { data ->
                _userInfo.value = data
            },
            failure = {
                _userInfo.value = emptyList()
            })

    }

    fun searchUser(page: Int = 0) {
        repository.searchUser(
            since = "0",
            page = page,
            success = { data ->
                _userInfo2.value = data
            },
            failure = {
                _userInfo.value = emptyList()
            }
        )
    }
}