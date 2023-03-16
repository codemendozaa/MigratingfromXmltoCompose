package com.example.migratingfromxmltocompose

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class ItemsToSaleAdapter : ListAdapter<ForSaleItem, ItemToSaleViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemToSaleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_dron_item, parent, false)
        return ItemToSaleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemToSaleViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)
    }

    fun setData(list: List<ForSaleItem>) {
        submitList(list)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ForSaleItem>() {
            override fun areItemsTheSame(oldItem: ForSaleItem, newItem: ForSaleItem): Boolean {
                return oldItem.label == newItem.label
            }

            override fun areContentsTheSame(oldItem: ForSaleItem, newItem: ForSaleItem): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }
}