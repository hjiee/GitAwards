package com.repo.gitawards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.repo.gitawards.util.listener.ClickEventListener
import com.repo.gitawards.util.listener.ViewHolderListener
import kotlinx.android.synthetic.main.recycler_item.view.*

class BaseRecyclerView {

    abstract class SimpleArrayAdapter<B : ViewDataBinding>(
        private val layoutResId: Int,
        private val list: List<String>,
        private val bindingVariableId: Int? = null,
        private val event: ClickEventListener? = null
    ) : RecyclerView.Adapter<ViewHolder<B>>() {



        var items: MutableList<String> = list.toMutableList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> =
            object : ViewHolder<B>(
                layoutResId = layoutResId,
                parent = parent,
                bindingVariableId = bindingVariableId,
                event = event
            ) {}

        override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
            holder.onBind(items[position])

        }

        override fun getItemCount(): Int = items.size

        fun updateData(newList: List<String>) {
            val diffUtilCallback =
                DiffUtil.calculateDiff(com.repo.gitawards.util.DiffUtil(newList, items))
            diffUtilCallback.dispatchUpdatesTo(this)
            items.clear()
            items.addAll(newList)
        }
    }

    abstract class ListAdapter<ITEM : Any, B : ViewDataBinding>(
        private val layoutResId: Int = -1,
        private val bindingVariableId: Int? = null,
        private val event: ClickEventListener? = null,
        diffCallback: DiffUtil.ItemCallback<ITEM>
    ) : androidx.recyclerview.widget.ListAdapter<ITEM, ViewHolder<B>>(diffCallback) {

        var items = listOf<ITEM>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> =
            object : ViewHolder<B>(
                layoutResId = layoutResId,
                parent = parent,
                bindingVariableId = bindingVariableId,
                event = event

            ) {}


        override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
            holder.onBind(items[position])
        }


    }

    abstract class Adapter<ITEM : Any, B : ViewDataBinding>(
        private val layoutResId: Int = -1,
        private val bindingVariableId: Int? = null,
        private val event : ClickEventListener? = null
    ) : RecyclerView.Adapter<ViewHolder<B>>() {

        var items = listOf<ITEM>()


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> =
            object : ViewHolder<B>(
                layoutResId = layoutResId,
                parent = parent,
                bindingVariableId = bindingVariableId,
                event = event

            ) {}


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
        private val parent: ViewGroup,
        private val bindingVariableId: Int? = null,
        private val event: ClickEventListener? = null
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            layoutResId,
            parent,
            false
        )
    ) {
        init {
            itemView.setOnClickListener {
                event?.onEvent(it)
            }
        }

        val binding: B = DataBindingUtil.bind(itemView)!!

        fun onBind(item: Any?) {
            itemView.tv_rank?.text = (adapterPosition+1).toString()
            bindingVariableId?.let {
                binding.setVariable(bindingVariableId, item)
            }
        }

    }
}