package com.repo.gitawards.ui.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.databinding.library.baseAdapters.BR
import com.repo.gitawards.R
import com.repo.gitawards.BaseRecyclerView
import com.repo.gitawards.base.BaseFragment
import com.repo.gitawards.databinding.FragmentMainBinding
import com.repo.gitawards.databinding.RecyclerItemBinding
import com.repo.gitawards.network.model.GithubResponse
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.recycler_item.view.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

//    val awardAdapter2 = BaseRecyclerView<GithubResponse>(R.layout.recycler_item)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.srlRefresh.setOnRefreshListener {
            viewModel.load2()
            srl_refresh.isRefreshing = false
        }

        binding.run {
            vm = viewModel
            rv_github.apply {
                adapter = object : BaseRecyclerView.Adapter<GithubResponse,RecyclerItemBinding>(
                    R.layout.recycler_item,
                    BR.response
                ) { }
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