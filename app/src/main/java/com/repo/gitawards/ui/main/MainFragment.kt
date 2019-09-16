package com.repo.gitawards.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import com.repo.gitawards.BaseRecyclerView
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseFragment
import com.repo.gitawards.databinding.ActivityMainBinding
import com.repo.gitawards.databinding.FragmentMainBinding
import com.repo.gitawards.databinding.RecyclerItemBinding
import com.repo.gitawards.network.model.GithubResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

//    val awardAdapter2 = BaseRecyclerView<GithubResponse>(R.layout.recycler_item)


    lateinit var activityMainBinding : ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        activityMainBinding = DataBindingUtil.inflate(inflater,R.layout.activity_main,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.srlRefresh.setOnRefreshListener {
            viewModel.load("kotlin")
            srl_refresh.isRefreshing = false
        }

        binding.run {
            vm = viewModel
            rv_github.apply {
                adapter = object : BaseRecyclerView.Adapter<GithubResponse,RecyclerItemBinding>(
                    R.layout.recycler_item,
                    BR.response
                ) {
                    override fun onCreateViewHolder(
                        parent: ViewGroup,
                        viewType: Int
                    ): BaseRecyclerView.ViewHolder<RecyclerItemBinding> {
                        return super.onCreateViewHolder(parent, viewType).apply {
                            binding.tvRank.text = "1"
                        }
                    }
                }
            }
        }

        progressOn()
        viewModel.load("java")
    }



    companion object {
        fun newInstance() = MainFragment().apply {
            arguments = Bundle().apply {

            }
        }

    }
}