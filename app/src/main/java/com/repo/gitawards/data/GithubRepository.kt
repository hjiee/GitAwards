package com.repo.gitawards.data

import com.repo.gitawards.data.source.GithubDataSource
import com.repo.gitawards.di.networkModule
import com.repo.gitawards.network.NetworkResponse
import com.repo.gitawards.network.api.GithubApi
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.util.LogUtil
import com.repo.gitawards.util.LogUtil.Companion.Loge
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepository(val githubApi: GithubApi) : GithubDataSource {

    fun getRank() {

    }

    fun getUsers() {

    }

    fun getRepository(networkResponse: NetworkResponse) {
        // TODO: 2019-08-16 네트워크 통신으로 데이터 가져오기


//        githubApi.getRepositories2("language:kotlin", "star", "desc")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                // Success
//                networkResponse.success(it)
//                Loge("success")
//
//            }, {
//                // Falure
//                Loge("Fail")
//            })

//        githubApi.getRepositories("language:kotlin", "star", "desc")
//            .enqueue(object : Callback<GithubResponse> {
//
//                override fun onResponse(
//                    call: Call<GithubResponse>,
//                    response: Response<GithubResponse>
//                ) {
//                    networkResponse.success(response)
//                    Loge("success : ${response.body()}")
//                }
//
//                override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
//                    networkResponse.fail()
//                    Loge("Fail : $t")
//                }
//            })
    }

    fun listAll(success: (Response<GithubResponse>) -> Unit, failur: () -> Unit) {

        githubApi.getRepositories("language:kotlin", "star", "desc")
            .enqueue(object : Callback<GithubResponse> {

                override fun onResponse(
                    call: Call<GithubResponse>,
                    response: Response<GithubResponse>
                ) {
                    success(response)
                }

                override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                    failur()
                }
            })
    }

    fun listAll2(success: (GithubResponse) -> Unit, failur: () -> Unit) {
        githubApi.getRepositories2("language:kotlin", "star", "desc")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                // Success
                success(it)
            }, {
                // Falure
                failur()
            })
    }

    fun search() {

    }
}