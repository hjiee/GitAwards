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
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    val awardAdapter = SimpleRecyclerAdapter(
        mutableListOf(
            AwardsEntity("1", "홍길동", "1", "1"),
            AwardsEntity("1", "김춘향", "1", "1"),
            AwardsEntity("1","신짱구","1","1"),
            AwardsEntity("1","오징어","1","1")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            rv_github.apply {
                adapter = awardAdapter
            }
        }

        viewModel.load()
        viewModel.load2()
//        viewModel.getRepository()
//        awardAdapter.notifyDataSetChanged()


    }

    companion object {
        fun newInstance() = MainFragment().apply {
            arguments = Bundle().apply {

            }
        }

    }
}