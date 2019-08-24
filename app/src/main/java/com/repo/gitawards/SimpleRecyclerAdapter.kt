package com.repo.gitawards

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.repo.gitawards.data.entity.AwardsEntity
import com.repo.gitawards.network.model.GithubResponse
import kotlinx.android.synthetic.main.recycler_item.view.*

class SimpleRecyclerAdapter(private val list : List<GithubResponse>) : RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list.get(position),position+1)
    }

//    fun addItem(award : AwardsEntity) {
//        list.add(award)
//        list.sortByDescending { it.star } // 내림차순 정렬
//        notifyDataSetChanged()
//    }

    class ViewHolder(parent : View) : RecyclerView.ViewHolder(parent) {

        fun onBind(award : GithubResponse, rank : Int) {
            itemView.run {
//                img_profile.setImageURI(Uri.parse(award.userProfileUrl))
//                tv_name.text = award.items.name
                tv_rank.text = rank.toString()
//                tv_star.text = award.items.starCount
            }
        }
    }
}