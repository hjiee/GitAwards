package com.repo.gitawards.ext

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.repo.gitawards.R
import com.repo.gitawards.SimpleRecyclerAdapter

@BindingAdapter(value = ["bindAdapter"])
fun RecyclerView.bindAdapter(layoutResId : Int) {
    adapter?.let {
        SimpleRecyclerAdapter<Any>(layoutResId)
    }
}

@BindingAdapter(value = ["bindItems"])
fun RecyclerView.bindItems(items : List<Any>?) {
    items?.let {
        (adapter as? SimpleRecyclerAdapter<Any>)?.run {
            replaceAll(items)
        }
    }
}
