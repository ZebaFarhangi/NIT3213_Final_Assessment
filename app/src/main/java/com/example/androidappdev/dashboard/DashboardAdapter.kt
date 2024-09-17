package com.example.androidappdev.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidappdev.R

class DashboardAdapter(
    private val onItemClick: (DashboardItem) -> Unit
) : ListAdapter<DashboardItem, DashboardAdapter.DashboardViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: DashboardItem) {
            // Bind data to the view (excluding description)
            itemView.findViewById<TextView>(R.id.assetType).text = item.assetType
            itemView.findViewById<TextView>(R.id.ticker).text = item.ticker
            itemView.findViewById<TextView>(R.id.currentPrice).text = "${item.currentPrice}"
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<DashboardItem>() {
        override fun areItemsTheSame(oldItem: DashboardItem, newItem: DashboardItem): Boolean {
            return oldItem.ticker == newItem.ticker
        }

        override fun areContentsTheSame(oldItem: DashboardItem, newItem: DashboardItem): Boolean {
            return oldItem == newItem
        }
    }
}
