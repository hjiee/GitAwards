package com.github.gitawards.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.github.gitawards.network.api.GithubApi
import com.github.gitawards.ui.AdsViewDialog
import com.github.gitawards.ui.main.MainViewModel
import com.github.gitawards.util.listener.OnBackPressedListener
import kotlinx.android.synthetic.main.activity_main.view.*
import org.koin.android.ext.android.inject

abstract class BaseActivity<B : ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {

    lateinit var binding: B

    val networkModel by inject<GithubApi>()
    val viewModel by inject<MainViewModel>()

    var backPressedListener: OnBackPressedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(layoutInflater, layoutId, null, false)
        setContentView(binding.root)
        binding.lifecycleOwner = this

    }

    override fun onBackPressed() {
        if (binding.root.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.root.drawer.closeDrawer(GravityCompat.START)

        } else {
            if (backPressedListener != null) {
                backPressedListener?.onBackpressed()
            } else {

                AdsViewDialog(binding.root.context).apply {
                    setPositiveButton {
                        super.onBackPressed()
                    }
                    setNegativeButton {
                        dismiss()
                    }
                }.show()
            }
        }
    }


    fun setBackPressed(listener: OnBackPressedListener) {
        backPressedListener = listener
    }

    fun removeBackPressed() {
        backPressedListener = null
    }


}