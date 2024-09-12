package com.example.androidappdev.dashboard.recyclerView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidappdev.R

class RecyclerviewAdapter: RecyclerView.Adapter<ViewHolder>() {
    private val dataList: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context) .inflate(R.layout.viewholder_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<String>){
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }
}