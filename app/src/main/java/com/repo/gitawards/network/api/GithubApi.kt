package com.repo.gitawards.network.api

import com.repo.gitawards.network.model.GithubResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    // repository
    // https://developer.github.com/v3/search/#search-users
    @GET("search/repositories")
    fun getRepositories(
        @Query("q") q : String,
        @Query("sort") sort : String,
        @Query("order") order : String
    ) : Call<GithubResponse>


    // repository
    // https://developer.github.com/v3/search/#search-users
    @GET("search/repositories")
    fun getRepositories2(
        @Query("q") q : String,
        @Query("sort") sort : String,
        @Query("order") order : String,
        @Query("page") page : Int
    ) : Single<GithubResponse>

}