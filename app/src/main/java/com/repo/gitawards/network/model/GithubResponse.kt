package com.repo.gitawards.network.model

import android.widget.AdapterView
import com.google.gson.annotations.SerializedName

data class GithubResponse(
    @SerializedName("items")
    val items: List<Items>
) {
    data class Items(
        @SerializedName("name")
        val name : String,
        @SerializedName("html_url")
        val htmlUrl : String,
        @SerializedName("stargazers_count")
        val starCount: String
    )
}
