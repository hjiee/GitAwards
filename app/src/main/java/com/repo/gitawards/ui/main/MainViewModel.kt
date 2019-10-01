package com.repo.gitawards.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.repo.gitawards.base.BaseViewModel
import com.repo.gitawards.data.GithubRepository
import com.repo.gitawards.network.model.GithubResponse.Items
import com.repo.gitawards.util.LogUtil

class MainViewModel(private val repository: GithubRepository) : BaseViewModel() {

    private val _githubInfo = MutableLiveData<List<Items>>()
    val githubInfo: LiveData<List<Items>> get() = _githubInfo

    private val _rank = MutableLiveData<String>()
    val rank: LiveData<String> get() = _rank

    private val _searchItem = MutableLiveData<String>()
    val searchItem : LiveData<String> get() = _searchItem

    // refresh면 true / 아니면 false
    private val _rvRefresh = MutableLiveData<Boolean>()
    val rvRefresh : LiveData<Boolean> get() = _rvRefresh.apply { false }

    // 결과값이 null이면 true, null이 아니면 false
    private val _stateIsEmpty = MutableLiveData<Boolean>()
    val stateIsEmpty: LiveData<Boolean> get() = _stateIsEmpty.apply { true }

    // edit text가 focus를 가지고 있으면 true, 아니면 false
    private val _stateHasFocus = MutableLiveData<Boolean>()
    val stateHasFocus: LiveData<Boolean> get() = _stateHasFocus.apply { false }



//    fun loadData() {
//        val timeS = System.currentTimeMillis()
//
//        repository.listLoad (
//            success = { data ->
//                val timeE = System.currentTimeMillis()
//                val time = timeE - timeS
//                LogUtil.Loge("NO RX($time) : $data")
//                _githubInfo.value = data
//            },
//            failure = {
//                LogUtil.Loge("NO RX Fail : $it")
//            })
//    }

    fun refresh() {
        _rvRefresh.value = true
        load(_searchItem.value ?: "",page = 0)
    }
    fun loadMore(page : Int) {
        _rvRefresh.value = false
        load(_searchItem.value ?: "",page = page)
    }
    fun load(language: String,page: Int) {
        val timeS = System.currentTimeMillis()

        repository.listLoad(
            type = language,
            page = page+1,
            success = { data ->
                val timeE = System.currentTimeMillis()
                val time = timeE - timeS
                LogUtil.Loge("RX($time) : ${data}")
                if(_githubInfo.value.isNullOrEmpty()) {
                    _githubInfo.value = data
                } else {
                    if(_rvRefresh.value ?: false) {
                        _githubInfo.value = data
                    }
                    else {
                        _githubInfo.value = _githubInfo.value?.let {
                            it.toMutableList().apply {
                                addAll(data!!)
                            }
                        }
                    }
                }
                _stateIsEmpty.value = false
            },
            failure = {
                LogUtil.Loge("RX Fail : $it")
                _githubInfo.value = emptyList()
                _stateIsEmpty.value = true
            })
    }

    fun changedFocus() {
        when (_stateHasFocus.value) {
            null -> _stateHasFocus.value = false
            else -> _stateHasFocus.value = _stateHasFocus.value?.not()
        }
    }
}