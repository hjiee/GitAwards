package com.repo.gitawards.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

fun Fragment.replaceFragment(fragment: Fragment, layoutId : Int) {
    fragmentManager?.beginTransaction()
        ?.replace(layoutId,fragment)
        ?.commitNow()
}


fun Fragment.replaceFragmentStack(fragment: Fragment, layoutId : Int) {
    fragmentManager?.beginTransaction()
        ?.replace(layoutId,fragment)
        ?.addToBackStack(null)
        ?.commit()
}

