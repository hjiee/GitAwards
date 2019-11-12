package com.github.gitawards.network.model

import com.google.gson.annotations.SerializedName

data class UserSearchResponse(
    @SerializedName("login")
    val login : String,
    @SerializedName("avatar_url")
    val profile : String,
    @SerializedName("repos_url")
    val repos : String,
    @SerializedName("url")
    val url : String
)