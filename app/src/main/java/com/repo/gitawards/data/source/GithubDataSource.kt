package com.repo.gitawards.data.source

import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.network.model.GithubResponseTest
import io.reactivex.disposables.Disposable
import retrofit2.Response

interface GithubDataSource {

    fun listLoad(
        success: (List<GithubResponse>) -> Unit,
        failure: (String) -> Unit
    )

    fun listLoad2(
        success: (GithubResponse) -> Unit,
        failure: (String) -> Unit
    ): Disposable


    fun listLoadTest(
        success: (List<GithubResponseTest>) -> Unit,
        failure: (String) -> Unit
    )

}