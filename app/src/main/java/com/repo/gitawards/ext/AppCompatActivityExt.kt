package com.repo.gitawards.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.replaceFragment(fragment : Fragment, layoutId : Int) {
    supportFragmentManager.beginTransaction()
        .replace(layoutId,fragment)
        .commitNow()
}