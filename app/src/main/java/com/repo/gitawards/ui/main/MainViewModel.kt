package com.repo.gitawards.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.repo.gitawards.R
import com.repo.gitawards.SimpleRecyclerAdapter
import com.repo.gitawards.base.BaseViewModel
import com.repo.gitawards.data.GithubRepository
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.network.model.GithubResponseTest
import com.repo.gitawards.util.LogUtil

class MainViewModel(private val repository: GithubRepository) : BaseViewModel() {

    private val _githubInfo = MutableLiveData<List<GithubResponse>>()
    val githubInfo : LiveData<List<GithubResponse>> get() = _githubInfo


    private val _githubInfoTest = MutableLiveData<List<GithubResponseTest>>()
    val githubInfoTest : LiveData<List<GithubResponseTest>> get() = _githubInfoTest


    fun load() {
        val timeS = System.currentTimeMillis()

        repository.listLoad (
            success = { data ->
                val timeE = System.currentTimeMillis()
                val time = timeE - timeS
                LogUtil.Loge("NO RX($time) : $data")
                _githubInfo.value = data
            },
            failure = {
                LogUtil.Loge("NO RX Fail : $it")
            })
    }

    fun load2() {
        val timeS = System.currentTimeMillis()
        repository.listLoad2(
            success = { data ->
                val timeE = System.currentTimeMillis()
                val time = timeE - timeS
                LogUtil.Loge("RX($time) : ${data}")

//                _githubInfo.value = data
            },
            failure = {
                LogUtil.Loge("RX Fail : $it")

            })
    }


    fun loadTest() {
        val timeS = System.currentTimeMillis()

        repository.listLoadTest (
            success = { data ->
                val timeE = System.currentTimeMillis()
                val time = timeE - timeS
                LogUtil.Loge("NO RX($time) : $data")
                _githubInfoTest.value = data
            },
            failure = {
                LogUtil.Loge("NO RX Fail : $it")
            })
    }
}