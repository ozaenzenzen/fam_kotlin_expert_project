package com.famandexpertapp1.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.famandexpertapp1.core.R
import com.famandexpertapp1.core.databinding.ItemListFranchiseBinding
import com.famandexpertapp1.core.domain.model.Franchise

class FranchiseAdapter : RecyclerView.Adapter<FranchiseAdapter.ListViewHolder>() {
    private var listData = ArrayList<Franchise>()
    var onItemClick: ((Franchise) -> Unit)? = null

    fun setData(newListData: List<Franchise>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_franchise, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListFranchiseBinding.bind(itemView)
        fun bind(data: Franchise) {
            with(binding) {
//                Glide.with(itemView.context)
//                    .load(data.image)
//                    .into(ivItemImage)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.slug
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}