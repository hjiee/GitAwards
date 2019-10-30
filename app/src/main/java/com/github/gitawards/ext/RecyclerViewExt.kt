package com.github.gitawards.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.gitawards.BaseRecyclerView

@BindingAdapter(value = ["bindItems"])
fun RecyclerView.bindItems(items : List<Any>?) {
    items?.let {
        (adapter as? BaseRecyclerView.Adapter<Any,*>)?.run {
            replaceAll(items)
        }
    }
}
