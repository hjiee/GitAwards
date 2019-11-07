package com.github.gitawards.network.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("items")
    val items : List<Items>
) {
    data class Items(
        @SerializedName("login")
        val login : String,
        @SerializedName("avatar_url")
        val profile : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("url")
        val url : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("repos_url")
        val repos : String,
        @SerializedName("repos_url")
        val repos : String
    )
}