package com.repo.gitawards.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET()
    fun getRank(@Query("") test : String)
}