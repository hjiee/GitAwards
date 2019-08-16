package com.repo.gitawards.data

import com.repo.gitawards.di.networkModule
import com.repo.gitawards.network.api.GithubApi
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.util.LogUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepositoryImpl(val githubApi : GithubApi) : GithubRepository {

    override fun getRank() {

    }

    override fun getUsers() {

    }

    override fun getRepository() {
        // TODO: 2019-08-16 네트워크 통신으로 데이터 가져오기


//        networkModel.getRepositories2("language:kotlin", "star", "desc")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                // Success
//                Loge("success")
//            }, {
//                // Falure
//                Loge("Fail")
//            })

        githubApi.getRepositories("language:kotlin", "star", "desc")
            .enqueue(object : Callback<List<GithubResponse>> {

                override fun onResponse(call: Call<List<GithubResponse>>, response: Response<List<GithubResponse>>) {
                    LogUtil.Loge("success")
                }

                override fun onFailure(call: Call<List<GithubResponse>>, t: Throwable) {
                    LogUtil.Loge("Fail")
                }

            })

    }
}