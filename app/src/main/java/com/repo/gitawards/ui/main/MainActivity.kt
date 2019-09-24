package com.repo.gitawards.ui.main

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseActivity
import com.repo.gitawards.databinding.ActivityMainBinding
import com.repo.gitawards.databinding.FragmentMainBinding
import com.repo.gitawards.ext.replaceFragment
import com.repo.gitawards.util.LogUtil.Companion.Loge
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_main.view.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.koin.android.ext.android.bind

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(MainFragment.newInstance(), binding.flContainer.id)

        initView()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun initView() {

        // 검색
//        binding.includeAppbar.edtSearchInput.setOnEditorActionListener { textView, i, keyEvent ->
//            viewModel.load(binding.includeAppbar.edtSearchInput.text.toString())
////            MainFragment.newInstance().search(binding.includeAppbar.edtSearchInput.text.toString())
//            true
//        }

//        binding.drawer.openDrawer(GravityCompat.START)
//        Loge(binding.drawer.isDrawerOpen(GravityCompat.START).toString())

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

    fun test() {
        setSupportActionBar(MainFragment.newInstance().binding.includeAppbar.toolbar)

        // 드로어레이아웃 토글
        ActionBarDrawerToggle(
            this,
            binding.drawer,
            MainFragment.newInstance().binding.includeAppbar.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ).let {
            binding.drawer.addDrawerListener(it)
            it.syncState()
            it.drawerArrowDrawable = DrawerArrowDrawable(this).apply {
                color = resources.getColor(R.color.colorDark, null)
            }
        }
    }
}
