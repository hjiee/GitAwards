package com.github.gitawards.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.github.gitawards.R
import com.github.gitawards.base.BaseActivity
import com.github.gitawards.databinding.ActivityMainBinding
import com.github.gitawards.databinding.FragmentMainBinding
import com.github.gitawards.ext.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_main.view.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(MainFragment.newInstance(), binding.flContainer.id)

        initView()
    }

    fun initView() {
        // 메뉴 선택
        binding.naviView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.language -> {

                }
                R.id.repository -> {

                }
                R.id.user -> {

                }
            }

            Toast.makeText(binding.root.context, it.title, Toast.LENGTH_SHORT).show()
            binding.root.edt_search_input.hint = it.title
            drawer.closeDrawer(GravityCompat.START)
            true
        }

    }


    fun open() {
        binding.drawer.openDrawer(GravityCompat.START)
    }

    fun close() {
        binding.drawer.closeDrawer(GravityCompat.END)
    }
}
