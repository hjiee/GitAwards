package com.github.gitawards.ui.github.users

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.gitawards.R
import com.github.gitawards.base.BaseFragment
import com.github.gitawards.databinding.FragmentSearchLanguageBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment :
    BaseFragment<FragmentSearchLanguageBinding>(R.layout.fragment_search_user) {

    val viewModel by viewModel<UserViewModel>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.load()

    }

    companion object {
        fun newInstance() = UsersFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }

}