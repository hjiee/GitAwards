package com.repo.gitawards

import com.repo.gitawards.data.GithubRepository
import com.repo.gitawards.network.api.GithubApi
import com.repo.gitawards.ui.main.MainViewModel
import org.junit.Before
import org.junit.Test

class ViewModelUnitTest {

    lateinit var githubApi : GithubApi
    lateinit var viewModel : MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel(GithubRepository(githubApi))
    }
    @Test
    fun main() {

        viewModel.getRepository()
    }
}
