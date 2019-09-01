package com.repo.gitawards.network.model

import android.widget.AdapterView
import androidx.core.util.rangeTo
import com.google.gson.annotations.SerializedName
import com.repo.gitawards.data.entity.AwardsEntity

data class GithubResponseTest(
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
