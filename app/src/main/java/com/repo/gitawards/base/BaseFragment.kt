package com.repo.gitawards.base

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView
import com.repo.gitawards.R
import com.repo.gitawards.ui.main.MainViewModel
import kotlinx.android.synthetic.main.loading.*
import org.koin.androidx.viewmodel.ext.android.viewModel

open class BaseFragment<B : ViewDataBinding>(private val layoutId : Int) : Fragment() {


    lateinit var binding : B
    lateinit var lottie : LottieAnimationView

    val viewModel by viewModel<MainViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater,layoutId,container,false)
        binding.lifecycleOwner = this
//        LayoutInflater.from(binding.root.context).inflate(R.layout.loading,container,false).let {
//            lottie = it.findViewById(R.id.lottie_loading)
//            lottie.playAnimation()
//        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this@BaseFragment
    }

    fun progressOn() {
        BaseApplication.getInstance().progressOn(lottie)
    }

    fun progressOff() {
        BaseApplication.getInstance().progressOff(lottie)

    }
}