package com.repo.gitawards.ui.myrepo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseFragment
import com.repo.gitawards.databinding.FragmentMyrepoBinding

class MyRepoFragment : BaseFragment<FragmentMyrepoBinding>(R.layout.fragment_myrepo) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}