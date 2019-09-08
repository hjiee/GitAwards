package com.repo.gitawards.ui.main

import android.os.Bundle
import com.repo.gitawards.R
import com.repo.gitawards.base.BaseActivity
import com.repo.gitawards.databinding.ActivityMainBinding
import com.repo.gitawards.ext.replaceFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(MainFragment.newInstance(),binding.flContainer.id)


    }
}
