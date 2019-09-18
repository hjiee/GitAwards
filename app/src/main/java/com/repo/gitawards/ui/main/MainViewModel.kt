package com.repo.gitawards.ui.main

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.repo.gitawards.base.BaseViewModel
import com.repo.gitawards.data.GithubRepository
import com.repo.gitawards.data.entity.AwardsEntity
import com.repo.gitawards.network.model.GithubResponse.Items
import com.repo.gitawards.util.LogUtil

class MainViewModel(private val repository: GithubRepository) : BaseViewModel() {

    private val _githubInfo = MutableLiveData<List<Items>>()
    val githubInfo : LiveData<List<Items>> get() = _githubInfo

    private val _closeVisiable = MutableLiveData<Boolean>()
    val closeVisiable : LiveData<Boolean> get() = _closeVisiable

    private val _rank = MutableLiveData<String>()
    val rank : LiveData<String> get() = _rank

    private val _resultIsEmpty = MutableLiveData<Boolean>()
    val resultIsEmpty : LiveData<Boolean> get() = _resultIsEmpty


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

    fun load(language : String) {
        val timeS = System.currentTimeMillis()

        repository.listLoad(
            type = language,
            success = { data ->
                val timeE = System.currentTimeMillis()
                val time = timeE - timeS
                LogUtil.Loge("RX($time) : ${data}")
                _githubInfo.value = data
                _resultIsEmpty.value = false
            },
            failure = {
                LogUtil.Loge("RX Fail : $it")
                _githubInfo.value = emptyList()
                _resultIsEmpty.value = true
            })

    }

    fun toggleVisiable() : Boolean = _closeVisiable.value?.not() ?: false

    fun refresh() {

    }

    fun onClick() {

    }
    fun onItemClick(position : Int) {


    }
}