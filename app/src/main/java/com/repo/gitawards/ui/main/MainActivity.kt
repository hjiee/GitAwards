package com.repo.gitawards.ui.main

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.core.view.GravityCompat
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseActivity
import com.repo.gitawards.databinding.ActivityMainBinding
import com.repo.gitawards.ext.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.bind

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(MainFragment.newInstance(), binding.flContainer.id)

        setSupportActionBar(binding.toolbar)
        ActionBarDrawerToggle(
            this,
            binding.drawer,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ).let {
            binding.drawer.addDrawerListener(it)
            it.syncState()
            it.drawerArrowDrawable = DrawerArrowDrawable(this).apply {
                color = resources.getColor(R.color.colorDark, null)
            }
        }

        binding.edtSearchInput.setOnEditorActionListener { textView, i, keyEvent ->
            viewModel.load2(binding.edtSearchInput.text.toString())

            true
        }

        binding.naviView.setNavigationItemSelectedListener {
            when(it.itemId) {

            }

            Toast.makeText(binding.root.context, it.title, Toast.LENGTH_SHORT).show()
            binding.textInputLayout.hint = it.title
            drawer.closeDrawer(GravityCompat.START)
            true
        }

    }
}
