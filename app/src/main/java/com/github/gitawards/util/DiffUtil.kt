package com.github.gitawards.util

import androidx.recyclerview.widget.DiffUtil

class DiffUtil(
    private val oldList : List<Any>,
    private val newList : List<Any>
) : DiffUtil.Callback() {
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? = oldList[oldItemPosition].equals(newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition].equals(newList[newItemPosition])

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == newList[newItemPosition]

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size
}