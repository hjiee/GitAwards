package com.github.gitawards.ui.github

import android.os.Bundle
import com.github.gitawards.R
import com.github.gitawards.base.BaseFragment
import com.github.gitawards.databinding.FragmentSearchLanguageBinding

class RepositoriesFragment : BaseFragment<FragmentSearchLanguageBinding>(R.layout.fragment_search_language) {

    companion object {
        fun newInstance() = RepositoriesFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}