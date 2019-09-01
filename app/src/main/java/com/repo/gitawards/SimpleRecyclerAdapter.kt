package com.repo.gitawards

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.repo.gitawards.data.entity.AwardsEntity
import com.repo.gitawards.databinding.RecyclerItemBinding
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.util.LogUtil
import kotlinx.android.synthetic.main.recycler_item.view.*

class SimpleRecyclerAdapter<ITEM : Any>(private val layoutResId : Int) :
    RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder>() {

    var items = listOf<ITEM>()

    fun replaceAll(items : List<ITEM>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        val binding = DataBindingUtil.inflate<RecyclerItemBinding>(
            LayoutInflater.from(parent.context),
            layoutResId,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.onBind(items[position] as GithubResponse.Items, position + 1)
    }

    class ViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(award: GithubResponse.Items, rank: Int) {
            binding.apply {
                tvName.text = award.name
                tvStar.text = award.starCount
                tvRank.text = rank.toString()
            }
        }
    }
}