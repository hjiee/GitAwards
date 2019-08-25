package com.repo.gitawards.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import com.repo.gitawards.ui.main.MainViewModel
import com.repo.gitawards.util.LogUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

open class BaseFragment<B : ViewDataBinding>(private val layoutId : Int) : Fragment() {


    lateinit var binding : B

    val viewModel by viewModel<MainViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater,layoutId,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this@BaseFragment

    }
}