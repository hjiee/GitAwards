package com.repo.gitawards.data

import com.repo.gitawards.data.source.GithubDataSource
import com.repo.gitawards.di.networkModule
import com.repo.gitawards.network.NetworkResponse
import com.repo.gitawards.network.api.GithubApi
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.network.model.GithubResponseTest
import com.repo.gitawards.util.LogUtil
import com.repo.gitawards.util.LogUtil.Companion.Loge
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.contracts.contract

class GithubRepository(val githubApi: GithubApi) : GithubDataSource {

    override fun listLoad(
        success: (List<GithubResponse>) -> Unit,
        failure: (String) -> Unit
    ) {
        githubApi.getRepositories("language:kotlin", "star", "desc")
            .enqueue(object : Callback<GithubResponse> {
                override fun onResponse(
                    call: Call<GithubResponse>,
                    response: Response<GithubResponse>
                ) {
                    if (response.isSuccessful) {
                        success(listOf())
                    }
                }

                override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                    failure(t.toString())
                }
            })
    }

    override fun listLoad2(
        success: (GithubResponse) -> Unit,
        failure: (String) -> Unit
    ): Disposable {
        return githubApi.getRepositories2("language:kotlin", "star", "desc")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                // Success
                success(it)
            }, {
                // Falure
                failure(it.toString())
            })
    }



    override fun listLoadTest(
        success: (List<GithubResponseTest>) -> Unit,
        failure: (String) -> Unit
    ) {
        githubApi.getRepositoriesTest("language:kotlin", "star", "desc")
            .enqueue(object : Callback<List<GithubResponseTest>> {
                override fun onResponse(
                    call: Call<List<GithubResponseTest>>,
                    response: Response<List<GithubResponseTest>>
                ) {
                    if (response.isSuccessful) {
                        success(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<List<GithubResponseTest>>, t: Throwable) {
                    failure(t.toString())
                }
            })
    }
}