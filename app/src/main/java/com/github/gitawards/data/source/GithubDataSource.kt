package com.github.gitawards.data.source

import com.github.gitawards.network.model.GithubLanguageResponse.Items
import io.reactivex.disposables.Disposable

interface GithubDataSource {

    fun loadLanguage(
        type : String?,
        page : Int,
        success: (List<Items>?) -> Unit,
        failure: (String) -> Unit
    ): Disposable

//    fun loadRepositiory() : Disposable

    fun loadUser(
        type : String?,
        page : Int,
        success: (List<Items>?) -> Unit,
        failure: (String) -> Unit
    ) : Disposable
}