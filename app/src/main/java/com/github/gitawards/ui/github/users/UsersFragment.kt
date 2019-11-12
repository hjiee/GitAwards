package com.github.gitawards.ui.github.users

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.github.gitawards.BaseRecyclerView
import com.github.gitawards.R
import com.github.gitawards.base.BaseFragment
import com.github.gitawards.databinding.FragmentUserBinding
import com.github.gitawards.network.model.UserResponse
import com.github.gitawards.network.model.UserSearchResponse
import kotlinx.android.synthetic.main.fragment_user.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment :
    BaseFragment<FragmentUserBinding>(R.layout.fragment_user) {

    private val viewModel by viewModel<UserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.load()
        viewModel.searchUser()

    }

    override fun initEventHandler() {

    }

    override fun initBinding() {
        binding.run {
            vm = viewModel
            rvGithubUser.apply {
                adapter = object : BaseRecyclerView.Adapter<UserSearchResponse,FragmentUserBinding>(
                    R.layout.recycler_user,
                    BR.response
                ) {
                    override fun onCreateViewHolder(
                        parent: ViewGroup,
                        viewType: Int
                    ): BaseRecyclerView.ViewHolder<FragmentUserBinding> {
                        return super.onCreateViewHolder(parent, viewType).apply {

                        }
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance() = UsersFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }

}