package com.repo.gitawards

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.repo.gitawards.databinding.RecyclerItemBinding
import com.repo.gitawards.network.model.GithubResponse
import kotlinx.android.synthetic.main.recycler_item.view.*

class BaseRecyclerView {
    abstract class Adapter<ITEM : Any, B : ViewDataBinding>(
        private val layoutResId: Int,
        private val bindingVariableId: Int? = null
    ) : RecyclerView.Adapter<ViewHolder<B>>() {

        var items = listOf<ITEM>()


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> =
            object : ViewHolder<B>(
                layoutResId = layoutResId,
                parent = parent,
                bindingVariableId = bindingVariableId
            ) { }
//        {
//            val binding = DataBindingUtil.inflate<RecyclerItemBinding>(
//                LayoutInflater.from(parent.context),
//                layoutResId,
//                parent,
//                false
//            )
//
//            return object : ViewHolder<B>(binding,bindingVariableId) {}
//        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
            holder.onBind(items[position])
        }

        fun replaceAll(items: List<ITEM>) {
            this.items = items
            notifyDataSetChanged()
        }


    }

    abstract class ViewHolder<out B : ViewDataBinding>(
        private val layoutResId: Int,
        private val parent : ViewGroup,
        private val bindingVariableId : Int? = null
    ) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layoutResId,parent,false)) {


        init {
            itemView.setOnClickListener {
                Toast.makeText(binding.root.context, adapterPosition.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        val binding : B = DataBindingUtil.bind(itemView)!!

        fun onBind(item: Any?) {
            bindingVariableId?.let {
                binding.setVariable(bindingVariableId,item)
            }
        }
    }
}