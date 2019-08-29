package com.repo.gitawards.network

import retrofit2.Response


interface NetworkResponse {
    fun <R> success(response: Response<R>) {

    }

    fun <R> success(response: R) {

    }



    fun fail() {

    }
}