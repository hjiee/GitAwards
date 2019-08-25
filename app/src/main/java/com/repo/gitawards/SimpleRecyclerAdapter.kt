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

class SimpleRecyclerAdapter(private val list: MutableList<AwardsEntity>) :
    RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        val binding = DataBindingUtil.inflate<RecyclerItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.recycler_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list.get(position), position + 1)
    }

    class ViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(award: AwardsEntity, rank: Int) {
            binding.apply {
                tvName.text = award.userName
                tvStar.text = award.star
                tvRank.text = rank.toString()
            }
        }
    }
}