package com.github.gitawards.network.model

import com.google.gson.annotations.SerializedName

data class GithubResponse(
    @SerializedName("items")
    val items: List<Items>
) {
    data class Items(
        @SerializedName("full_name")
        val repoName : String,
        @SerializedName("stargazers_count")
        val starCount: String,
        @SerializedName("forks_count")
        val forkCount: String,
        @SerializedName("owner")
        val owner : Owner
    )
    data class Owner(
        @SerializedName("avatar_url")
        val avatar_url : String,
        @SerializedName("login")
        val userName : String

    )

}
