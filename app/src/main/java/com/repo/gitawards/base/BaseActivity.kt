package com.repo.gitawards.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.repo.gitawards.di.networkModule
import com.repo.gitawards.di.viewModelModule
import org.koin.android.ext.android.inject

open class BaseActivity : AppCompatActivity() {

//    val viewModel : BaseViewModel by inject<viewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}