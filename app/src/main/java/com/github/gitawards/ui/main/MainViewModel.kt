package com.github.gitawards.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.gitawards.base.BaseViewModel
import com.github.gitawards.data.GithubRepository
import com.github.gitawards.network.model.GithubResponse.Items
import com.github.gitawards.util.LogUtil

class MainViewModel(private val repository: GithubRepository) : BaseViewModel() {

    private val EXTRA_DEFAULT_LANGUADE = "javascript"
    private val _githubInfo = MutableLiveData<List<Items>>()
    val githubInfo: LiveData<List<Items>> get() = _githubInfo

    private val _rank = MutableLiveData<String>()
    val rank: LiveData<String> get() = _rank

    // refresh면 true / 아니면 false
    private val _rvRefresh = MutableLiveData<Boolean>()
    val rvRefresh : LiveData<Boolean> get() = _rvRefresh.apply { false }

    // 결과값이 null이면 true, null이 아니면 false
    private val _stateIsEmpty = MutableLiveData<Boolean>()
    val stateIsEmpty: LiveData<Boolean> get() = _stateIsEmpty.apply { true }

    // edit text가 focus를 가지고 있으면 true, 아니면 false
    private val _stateHasFocus = MutableLiveData<Boolean>()
    val stateHasFocus: LiveData<Boolean> get() = _stateHasFocus.apply { false }

    // 검색 값
    private val _searchText = MutableLiveData<String>()
    val searchText : LiveData<String> get() = _searchText



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

    fun setSearchText(item : String) {
        _searchText.value = item
    }
    fun refresh() {
        _rvRefresh.value = true
        load()
    }
    fun loadMore(page : Int) {
        _rvRefresh.value = false
        load(page = page)
    }
    fun load(page: Int = 0) {
        val timeS = System.currentTimeMillis()

        repository.listLoad(
            type = if(_searchText.value.isNullOrEmpty()) EXTRA_DEFAULT_LANGUADE else _searchText.value,
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
//                LogUtil.Loge("RX Fail : $it")
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