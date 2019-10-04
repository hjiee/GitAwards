package com.repo.gitawards.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.repo.gitawards.BaseRecyclerView
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseFragment
import com.repo.gitawards.databinding.FragmentSearchBinding
import com.repo.gitawards.databinding.RecyclerItemBinding
import com.repo.gitawards.databinding.RecyclerLanguageBinding
import com.repo.gitawards.ext.showKeyboard
import com.repo.gitawards.network.model.GithubResponse
import kotlinx.android.synthetic.main.fragment_main.*

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // 이벤트 설정
        initEventHandler()
        // 바인딩 설정
        initBinding()
    }

    fun initEventHandler() {
        binding.includeAppbar.hasFocus = true
        binding.includeAppbar.edtSearchInput.let {
            it.visibility = View.VISIBLE
            it.requestFocus()
            it.isFocusableInTouchMode = true
            context?.showKeyboard(it)
        }
    }
    fun initBinding() {
//        binding.run {
//            rv_github.apply {
//                adapter = object : BaseRecyclerView.ListAdapter<String, RecyclerLanguageBinding>(
//                    R.layout.recycler_language
//                ) {
//                    override fun onCreateViewHolder(
//                        parent: ViewGroup,
//                        viewType: Int
//                    ): BaseRecyclerView.ViewHolder<RecyclerLanguageBinding> {
//                        return super.onCreateViewHolder(parent, viewType).apply {
//                            //
//                        }
//                    }
//                }
//            }
//        }
    }
    companion object {
        fun newInstance() = SearchFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}