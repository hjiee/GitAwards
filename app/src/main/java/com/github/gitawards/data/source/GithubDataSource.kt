package com.github.gitawards.data.source

import com.github.gitawards.network.model.GithubResponse.Items
import io.reactivex.disposables.Disposable

interface GithubDataSource {

//    fun listLoad(
//        success: (List<Items>?) -> Unit,
//        failure: (String) -> Unit
//    )

    fun listLoad(
        type : String?,
        page : Int,
        success: (List<Items>?) -> Unit,
        failure: (String) -> Unit
    ): Disposable
}