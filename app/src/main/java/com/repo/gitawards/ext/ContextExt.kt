package com.repo.gitawards.ext

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Context.showKeyboard(view : View) {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).let {
        it.showSoftInput(view,0)
    }
}

fun Context.hideKeyboard(view : View) {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).let {
        it.hideSoftInputFromWindow(view.windowToken,0)
    }
}