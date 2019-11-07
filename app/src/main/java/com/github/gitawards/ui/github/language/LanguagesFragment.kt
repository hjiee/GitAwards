package com.github.gitawards.ui.github.language

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.dino.library.util.EndlessRecyclerViewScrollListener
import com.github.gitawards.BaseRecyclerView
import com.github.gitawards.R
import com.github.gitawards.base.BaseFragment
import com.github.gitawards.databinding.FragmentSearchLanguageBinding
import com.github.gitawards.databinding.RecyclerItemBinding
import com.github.gitawards.ext.replaceFragment
import com.github.gitawards.network.model.GithubLanguageResponse
import com.github.gitawards.ui.main.MainActivity
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.appbar_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LanguagesFragment :
    BaseFragment<FragmentSearchLanguageBinding>(R.layout.fragment_search_language) {

    val viewModel by viewModel<LanguageViewModel>()

    // paging
    private val endScrollListener: RecyclerView.OnScrollListener by lazy {
        object : EndlessRecyclerViewScrollListener(binding.rvGithub.layoutManager!!) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                viewModel.loadMore(page)
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//         검색한 값을 설정한다. defalut = ""
        arguments.apply {
            (this?.get(R.string.search_input.toString()) ?: "").let {
                viewModel.setSearchText(it.toString())
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 이벤트 설정
        initEventHandler()
        // 바인딩 설정
        initBinding()
//        progressOn()

        ad_bottom.apply {
            AdRequest.Builder().build().let {
                loadAd(it)
            }
        }

        viewModel.load()
    }

    fun initEventHandler() {
        refresh()
        buttonClick()
    }

    fun initBinding() {
        binding.run {
            vm = viewModel
            rv_github.apply {
                adapter = object : BaseRecyclerView.Adapter<GithubResponse, RecyclerItemBinding>(
                    R.layout.recycler_item,
                    BR.response
                ) {
                    override fun onCreateViewHolder(
                        parent: ViewGroup,
                        viewType: Int
                    ): BaseRecyclerView.ViewHolder<RecyclerItemBinding> {
                        return super.onCreateViewHolder(parent, viewType).apply {
                            //                            itemView.tv_rank.text = this.let { adapterPosition.plus(1).toString() }
                        }
                    }
                }
                addOnScrollListener(endScrollListener)
            }
            edt_search_input.apply {
                binding.includeAppbar.isVisiable = true
                clearFocus()
                isFocusableInTouchMode = false
                setText(viewModel.searchText.value)
            }
            arguments.apply {
                (this?.get(R.string.search_input.toString()) ?: "").let {
                    if (!it.toString().isNullOrEmpty())
                        binding.includeAppbar.isEmpty = false
                }
            }
        }
    }


    fun refresh() {
        binding.srlRefresh.setOnRefreshListener {
            viewModel.refresh()
            srl_refresh.isRefreshing = false
        }
    }

    fun buttonClick() {
        // x 버튼 클릭
        binding.includeAppbar.ibClear.setOnClickListener {
            binding.includeAppbar.edtSearchInput.setText("")
            binding.includeAppbar.isEmpty = true
            viewModel.setSearchText("")
            viewModel.refresh()

        }
        // 토글 버튼 클릭
        binding.includeAppbar.ibToggle.setOnClickListener {
            (activity as MainActivity).open()
        }
        // 검색 버튼 클릭
        binding.includeAppbar.ibSearch.setOnClickListener {
            SearchLanguageFragment.newInstance().let {
                it.arguments =
                    bundleOf(Pair(R.string.search_input.toString(), viewModel.searchText.value))
                replaceFragment(it, R.id.fl_container)
            }
        }
    }

    companion object {
        fun newInstance() = LanguagesFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}


