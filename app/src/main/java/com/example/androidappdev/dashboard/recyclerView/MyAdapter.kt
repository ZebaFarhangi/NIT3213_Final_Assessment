package com.example.androidappdev.dashboard.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidappdev.R
import com.example.androidappdev.dashboard.data.Entity

class MyAdapter: RecyclerView.Adapter<ViewHolder>() {
    private val dataList: MutableList<String> = mutableListOf()

    //Created single view-item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context) .inflate(R.layout.viewholder_layout, parent, false)
        return ViewHolder(view)
    }
    //this function specify  how many of those view need to be created
    override fun getItemCount(): Int {
        return dataList.size
    }

    //binding each view item that is view correspond to it.
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }





}

