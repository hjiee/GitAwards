package com.repo.gitawards.ui.main

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import com.repo.gitawards.BaseRecyclerView
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseFragment
import com.repo.gitawards.databinding.AppbarMainBinding
import com.repo.gitawards.databinding.FragmentMainBinding
import com.repo.gitawards.databinding.RecyclerItemBinding
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.util.LogUtil.Companion.Loge
import com.repo.gitawards.util.hideKeyboard
import com.repo.gitawards.util.showKeyboard
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    lateinit var appBarBinding : AppbarMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        appBarBinding = DataBindingUtil.inflate(inflater,R.layout.appbar_main,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 이벤트 설정
        initEventHandler()
        // 바인딩 설정
        initBinding()
//        progressOn()
        viewModel.load("java")
    }

    fun initEventHandler() {
        refresh()
        buttonClick()
        editInputChanged()
    }

    fun initBinding() {
        appBarBinding.run {
            vm = viewModel
        }
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
                            binding.tvRank.text = "1"
                        }
                    }
                }
            }
        }
    }

    fun editInputChanged() {
        // 검색버튼
        binding.includeAppbar.edtSearchInput.apply {
            // 입력 완료 이벤트
            setOnEditorActionListener { textView, i, keyEvent ->
                viewModel.load(binding.includeAppbar.edtSearchInput.text.toString())
                true
            }
            // 포커스 변경 이벤트
            setOnFocusChangeListener { view, hasFocus ->
                viewModel.changedFocus()
                Loge(viewModel.stateHasFocus.value.toString())
            }
            // 텍스트 변경 이벤트
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {

                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
                   viewModel.changedText()
                }
            })
        }
    }

    fun refresh() {
        binding.srlRefresh.setOnRefreshListener {
            //viewModel.load("kotlin")
            srl_refresh.isRefreshing = false
        }
    }

    fun buttonClick() {
        // x 버튼 클릭
        binding.includeAppbar.ibClear.setOnClickListener {
            binding.includeAppbar.edtSearchInput.run {
                setText("")
                clearFocus()
                visibility = View.INVISIBLE
                context?.hideKeyboard(it)
            }
        }
        // 토글 버튼 클릭
        binding.includeAppbar.ibToggle.setOnClickListener {
            (activity as MainActivity).open()
        }
        // 검색 버튼 클릭
        binding.includeAppbar.ibSearch.setOnClickListener {
            binding.includeAppbar.edtSearchInput.let {
//                it.visibility = View.VISIBLE
                viewModel.changedEditText()
                it.requestFocus()
                context?.showKeyboard(binding.includeAppbar.edtSearchInput)
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment().apply {
            arguments = Bundle().apply {

            }
        }

    }
}


