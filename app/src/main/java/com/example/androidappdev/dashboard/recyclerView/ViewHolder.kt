package com.example.androidappdev.dashboard.recyclerView

import android.service.autofill.UserData
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidappdev.R

class ViewHolder (private val view: View): RecyclerView.ViewHolder(view) {

    fun bind(dataValue: String) {
        view.findViewById<TextView>(R.id.viewHoldertext).text = dataValue
    }
    private val textView: TextView = view.findViewById(R.id.ScreenPage)


}