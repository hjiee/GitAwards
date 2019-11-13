package com.github.gitawards.data

import com.github.gitawards.data.source.GithubDataSource
import com.github.gitawards.network.api.GithubApi
import com.github.gitawards.network.model.GithubResponse
import com.github.gitawards.network.model.UserResponse
import com.github.gitawards.network.model.UserSearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class GithubRepository(val githubApi: GithubApi) : GithubDataSource {

    override fun loadLanguage(
        type: String?,
        page: Int,
        success: (List<GithubResponse.Items>?) -> Unit,
        failure: (String) -> Unit
    ): Disposable {
        return githubApi.getLanguage("language:${type}", "stars", "desc", page)
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

    override fun loadUser(
        type: String?,
        page: Int,
        success: (List<UserResponse.Items>?) -> Unit,
        failure: (String) -> Unit
    ): Disposable {
        return githubApi.getUsers("$type", "", "desc", page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                success(it.items)
            }, {
                failure(it.toString())
            })
    }


    override fun searchUser(
        since: String,
        page: Int,
        success: (List<UserSearchResponse>?) -> Unit,
        failure: (String) -> Unit
    ): Disposable {
        return githubApi.searchUser(since,page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                success(it)
            }, {
                failure(it.toString())
            })
    }
}