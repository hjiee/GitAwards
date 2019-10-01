package com.repo.gitawards.data

import com.repo.gitawards.data.source.GithubDataSource
import com.repo.gitawards.network.api.GithubApi
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.network.model.GithubResponse.Items
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepository(val githubApi: GithubApi) : GithubDataSource {

//    fun listLoad(
//        success: (List<Items>?) -> Unit,
//        failure: (String) -> Unit
//    ) {
//        githubApi.getRepositories("language:kotlin", "star", "desc")
//            .enqueue(object : Callback<GithubResponse> {
//                override fun onResponse(
//                    call: Call<GithubResponse>,
//                    response: Response<GithubResponse>
//                ) {
//
//                    if (response.isSuccessful) {
//                        success(response.body()?.items)
//                    }
//                }
//
//                override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
//                    failure(t.toString())
//                }
//            })
//    }

    override fun listLoad(
        type : String,
        page : Int,
        success: (List<Items>?) -> Unit,
        failure: (String) -> Unit
    ): Disposable {
        return githubApi.getRepositories2("language:${type}", "star", "desc",page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                // Success
                success(it.items)
            }, {
                // Falure
                failure(it.toString())
            })
    }

}