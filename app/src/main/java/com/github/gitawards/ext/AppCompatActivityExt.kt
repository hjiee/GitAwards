package com.github.gitawards.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragment(fragment : Fragment, layoutId : Int) {
    supportFragmentManager.beginTransaction()
        .replace(layoutId,fragment)
        .commitNow()
}