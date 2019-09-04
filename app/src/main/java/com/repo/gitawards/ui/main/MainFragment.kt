package com.repo.gitawards.ui.main

import android.os.Bundle
import android.view.View
import com.repo.gitawards.R
import com.repo.gitawards.SimpleRecyclerAdapter
import com.repo.gitawards.base.BaseFragment
import com.repo.gitawards.data.entity.AwardsEntity
import com.repo.gitawards.databinding.FragmentMainBinding
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.util.LogUtil
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    val awardAdapter2 = SimpleRecyclerAdapter<GithubResponse>(R.layout.recycler_item)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            vm = viewModel
            rv_github.apply {
                adapter = awardAdapter2
            }
        }

//        viewModel.load()
        viewModel.load2()

    }

    companion object {
        fun newInstance() = MainFragment().apply {
            arguments = Bundle().apply {

            }
        }

    }
}