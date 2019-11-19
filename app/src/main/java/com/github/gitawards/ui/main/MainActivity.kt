package com.github.gitawards.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import com.github.gitawards.R
import com.github.gitawards.base.BaseActivity
import com.github.gitawards.databinding.ActivityMainBinding
import com.github.gitawards.ext.replaceFragment
import com.github.gitawards.ui.github.language.LanguagesFragment
import com.github.gitawards.ui.github.repositories.RepositoriesFragment
import com.github.gitawards.ui.github.users.UsersFragment
import com.github.gitawards.ui.myrepo.MyRepoFragment
import com.github.gitawards.util.LogUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_main.view.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        replaceFragment(MyRepoFragment.newInstance(), binding.flContainer.id)
        replaceFragment(UsersFragment.newInstance(), binding.flContainer.id)

        initView()
    }

    fun initView() {
        // 메뉴 선택
        binding.naviView.apply {
            setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        replaceFragment(MyRepoFragment.newInstance(), binding.flContainer.id)
                    }
                    R.id.language -> {
                        replaceFragment(LanguagesFragment.newInstance(), binding.flContainer.id)
                    }
                    R.id.repository -> {
                        replaceFragment(RepositoriesFragment.newInstance(), binding.flContainer.id)
                    }
                    R.id.user -> {
                        replaceFragment(UsersFragment.newInstance(), binding.flContainer.id)
                    }
                }

//            Toast.makeText(binding.root.context, it.title, Toast.LENGTH_SHORT).show()
                if (it.itemId != R.id.home) binding.root.edt_search_input.hint = it.title
                drawer.closeDrawer(GravityCompat.START)
                true
            }
        }
    }

    fun toggleClick(view : View) {
        open()
        LogUtil.Loge("test")
    }

    fun open() {
        binding.drawer.openDrawer(GravityCompat.START)
    }

    fun close() {
        binding.drawer.closeDrawer(GravityCompat.END)
    }
}
