package com.repo.gitawards.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.repo.gitawards.BaseRecyclerView
import java.util.Collections.replaceAll

@BindingAdapter(value = ["bindItems"])
fun RecyclerView.bindItems(items : List<Any>?) {
    items?.let {
        (adapter as? BaseRecyclerView.Adapter<Any,*>)?.run {
            replaceAll(items)
        }
    }
}
