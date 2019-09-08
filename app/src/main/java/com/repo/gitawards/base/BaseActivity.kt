package com.repo.gitawards.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.repo.gitawards.network.api.GithubApi
import com.repo.gitawards.ui.main.MainViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseActivity<B : ViewDataBinding>(private val layoutId : Int) : AppCompatActivity() {

    lateinit var binding : B

    val networkModel by inject<GithubApi>()
    val viewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(layoutInflater,layoutId,null,false)
        setContentView(binding.root)
        binding.lifecycleOwner = this

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}