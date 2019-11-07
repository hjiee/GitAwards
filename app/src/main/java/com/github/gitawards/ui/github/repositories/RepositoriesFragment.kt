package com.github.gitawards.ui.github.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.github.gitawards.R
import com.github.gitawards.base.BaseFragment
import com.github.gitawards.databinding.FragmentSearchLanguageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoriesFragment : BaseFragment<FragmentSearchLanguageBinding>(R.layout.fragment_search_language) {

    val viewModel by viewModel<RepositoryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance() = RepositoriesFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}