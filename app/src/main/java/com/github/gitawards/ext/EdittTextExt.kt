package com.github.gitawards.ext

import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["enterAction"])
fun EditText.enterAction(s : String) {
    this.setOnEditorActionListener { textView, i, keyEvent ->

        true
    }
}