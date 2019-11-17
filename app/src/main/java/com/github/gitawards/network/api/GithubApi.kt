package com.github.gitawards.network.api

import com.github.gitawards.network.model.GithubResponse
import com.github.gitawards.network.model.UserResponse
import com.github.gitawards.network.model.UserSearchResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    // repository
    // https://developer.github.com/v3/search/#search-users
//    @GET("search/repositories")
//    fun getRepositories(
//        @Query("q") q : String,
//        @Query("sort") sort : String,
//        @Query("order") order : String
//    ) : Call<GithubResponse>


    // language
    // https://developer.github.com/v3/search/#search-users
    @GET("search/repositories")
    fun getLanguage(
        @Query("q") q : String,
        @Query("sort") sort : String,
        @Query("order") order : String,
        @Query("page") page : Int
    ) : Single<GithubResponse>


    // repository
    // https://developer.github.com/v3/search/#search-users
    @GET("search/repositories")
    fun getRepositories(
        @Query("q") q : String,
        @Query("sort") sort : String,
        @Query("order") order : String,
        @Query("page") page : Int
    ) : Single<GithubResponse>

    // repository
    // https://developer.github.com/v3/search/#search-users
    @GET("search/users")
    fun getUsers(
        @Query("q") q : String,
        @Query("sort") sort : String,
        @Query("order") order : String,
        @Query("page") page : Int
    ) : Single<UserResponse>

    @GET("users")
    fun searchUser(
        @Query("since") since : String,
        @Query("page") page : Int
    ) : Single<List<UserSearchResponse>>
}