package com.repo.gitawards.data.source

import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.network.model.GithubResponse.Items
import io.reactivex.disposables.Disposable

interface GithubDataSource {

    fun listLoad(
        success: (List<Items>?) -> Unit,
        failure: (String) -> Unit
    )

    fun listLoad2(
        input : String,
        success: (List<Items>?) -> Unit,
        failure: (String) -> Unit
    ): Disposable
}