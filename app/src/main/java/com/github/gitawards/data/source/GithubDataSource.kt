package com.github.gitawards.data.source

import com.github.gitawards.network.model.GithubResponse
import com.github.gitawards.network.model.UserResponse
import com.github.gitawards.network.model.UserSearchResponse
import io.reactivex.disposables.Disposable

interface GithubDataSource {

    fun loadLanguage(
        type : String?,
        page : Int,
        success: (List<GithubResponse.Items>?) -> Unit,
        failure: (String) -> Unit
    ): Disposable

//    fun loadRepositiory() : Disposable

    fun loadUser(
        type : String?,
        page : Int,
        success: (List<UserResponse.Items>?) -> Unit,
        failure: (String) -> Unit
    ) : Disposable

    fun searchUser(
        since : String,
        page : Int,
        success : (List<UserSearchResponse>?) -> Unit,
        failure: (String) -> Unit
    ) : Disposable
}