package com.repo.gitawards

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.repo.gitawards.databinding.RecyclerItemBinding
import com.repo.gitawards.network.model.GithubResponse

class BaseRecyclerView {
    abstract class Adapter<ITEM : Any, B : ViewDataBinding>(
        private val layoutResId: Int,
        private val bindingVariableId: Int? = null
    ) : RecyclerView.Adapter<ViewHolder<B>>() {

        var items = listOf<ITEM>()


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> {
            val binding = DataBindingUtil.inflate<RecyclerItemBinding>(
                LayoutInflater.from(parent.context),
                layoutResId,
                parent,
                false
            )
            return object : ViewHolder<B>(binding,bindingVariableId) {}
        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
            holder.onBind(items[position])
        }

        fun replaceAll(items: List<ITEM>) {
            this.items = items
            notifyDataSetChanged()
        }


    }

    abstract class ViewHolder<B : ViewDataBinding>(
        private val binding: RecyclerItemBinding,
        private val bindingVariableId : Int? = null
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Any?) {
            bindingVariableId?.let {
                binding.setVariable(bindingVariableId,item)
            }
        }
    }
}