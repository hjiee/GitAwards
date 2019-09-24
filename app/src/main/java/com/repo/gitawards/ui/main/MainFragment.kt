package com.repo.gitawards.ui.main

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.repo.gitawards.BaseRecyclerView
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseFragment
import com.repo.gitawards.databinding.ActivityMainBinding
import com.repo.gitawards.databinding.FragmentMainBinding
import com.repo.gitawards.databinding.RecyclerItemBinding
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.util.LogUtil.Companion.Loge
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.appbar_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.bind

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        activityMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.activity_main, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.srlRefresh.setOnRefreshListener {
            Loge(activityMainBinding.drawer.isDrawerOpen(GravityCompat.START).toString())

//            viewModel.load("kotlin")
            srl_refresh.isRefreshing = false
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

        // 검색
        binding.includeAppbar.edtSearchInput.apply {
            setOnEditorActionListener { textView, i, keyEvent ->
                viewModel.load(binding.includeAppbar.edtSearchInput.text.toString())
                true
            }
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    when (char.isNullOrEmpty()) {
                        // 입력된 텍스트가 없을때
                        true -> {
                            binding.includeAppbar.ibClear.visibility = View.INVISIBLE
                            binding.includeAppbar.ibSearch.visibility = View.VISIBLE
                        }
                        // 입력된 텍스트가 있을때
                        false -> {
                            binding.includeAppbar.ibClear.visibility = View.VISIBLE
                            binding.includeAppbar.ibSearch.visibility = View.INVISIBLE

                        }
                    }
                }
            })
        }


        // x 버튼 클릭
        binding.includeAppbar.ibClear.setOnClickListener {
            binding.includeAppbar.edtSearchInput.setText("")
        }
        // 토글 버튼 클릭
        binding.includeAppbar.ibToggle.setOnClickListener {
            (activity as MainActivity).open()
        }
        // 검색 버튼 클릭
        binding.includeAppbar.ibSearch.setOnClickListener {
            binding.includeAppbar.edtSearchInput.let {
                it.visibility = View.VISIBLE
                it.isFocusableInTouchMode = true
                it.requestFocus()
                (context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(
                    it,
                    0
                )
            }
        }

//        progressOn()
        viewModel.load("java")
    }

    companion object {
        fun newInstance() = MainFragment().apply {
            arguments = Bundle().apply {

            }
        }

    }

}


