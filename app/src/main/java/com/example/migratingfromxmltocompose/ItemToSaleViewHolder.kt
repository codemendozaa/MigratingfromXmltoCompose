package com.example.migratingfromxmltocompose

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.migratingfromxmltocompose.databinding.ViewholderDronItemBinding

class ItemToSaleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewholderDronItemBinding

    init {
        binding = ViewholderDronItemBinding.bind(view)
    }

    fun bind(item: ForSaleItem) {
        with(binding) {
            textViewLabel.text = item.label
            textViewDescription.text = item.description
            textViewPrice.text = item.price
            appCompatImageView.setBackgroundResource(item.itemImage)
        }
    }

}