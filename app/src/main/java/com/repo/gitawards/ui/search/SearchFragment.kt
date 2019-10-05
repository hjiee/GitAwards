package com.repo.gitawards.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.library.baseAdapters.BR
import com.repo.gitawards.BaseRecyclerView
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseFragment
import com.repo.gitawards.databinding.FragmentSearchBinding
import com.repo.gitawards.databinding.RecyclerLanguageBinding
import com.repo.gitawards.ext.hideKeyboard
import com.repo.gitawards.ext.replaceFragment
import com.repo.gitawards.ext.showKeyboard
import com.repo.gitawards.ui.main.MainFragment
import com.repo.gitawards.util.FinalVariableUtil.Companion.LanguageViewType
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    val viewModel by viewModel<SearchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 이벤트 설정
        initEventHandler()
        // 바인딩 설정
        initBinding()
    }

    fun initEventHandler() {
        buttonClick()
        editInputChanged()

        binding.includeAppbar.hasFocus = true
        binding.includeAppbar.isVisiable = true
        binding.includeAppbar.edtSearchInput.let {

            it.requestFocus()
            it.isFocusableInTouchMode = true
            context?.showKeyboard(it)
        }
    }

    fun buttonClick() {
        // x 버튼 클릭
        binding.includeAppbar.ibClear.setOnClickListener {
            binding.includeAppbar.edtSearchInput.run {
                setText("")
            }
        }
        // 토글 버튼
        binding.includeAppbar.ibToggle.setOnClickListener {
            context?.hideKeyboard(it)
            replaceFragment(MainFragment.newInstance(), R.id.fl_container)
        }

    }

    fun editInputChanged() {
        // 검색버튼
        binding.includeAppbar.edtSearchInput.apply {
            // 입력 완료 이벤트
            setOnEditorActionListener { textView, i, keyEvent ->
                context?.hideKeyboard(textView)

                MainFragment.newInstance().let {
                    it.arguments = bundleOf(Pair(R.string.search_input.toString(), this.text))
                    replaceFragment(it, R.id.fl_container)
                }
                true
            }

            // 텍스트 변경 이벤트
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {

                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    when (char.isNullOrEmpty()) {
                        true -> binding.includeAppbar.isEmpty = true
                        false -> binding.includeAppbar.isEmpty = false
                    }
                }
            })
        }
    }

    fun initBinding() {
        binding.run {
            rv_search_language.apply {
                adapter = object : BaseRecyclerView.SimpleArrayAdapter<RecyclerLanguageBinding>(
                    R.layout.recycler_language,
                    resources.getStringArray(R.array.code_language).toList(),
                    BR.item
                ) {
                    override fun onCreateViewHolder(
                        parent: ViewGroup,
                        viewType: Int
                    ): BaseRecyclerView.ViewHolder<RecyclerLanguageBinding> {
                        return super.onCreateViewHolder(parent, LanguageViewType).apply {
                        }
                    }
                }
            }
        }

    }
    fun onClickItem() {
        Toast.makeText(context, "test", Toast.LENGTH_SHORT).show()
    }


    companion object {
        fun newInstance() = SearchFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}