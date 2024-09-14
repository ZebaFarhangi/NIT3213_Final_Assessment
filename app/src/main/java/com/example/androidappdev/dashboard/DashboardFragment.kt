package com.example.androidappdev.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidappdev.R
import com.example.androidappdev.dashboard.data.Entity
import com.example.androidappdev.dashboard.recyclerView.MyAdapter

class DashboardFragment : Fragment() {
    //get reference to all this data, extract data ,Receive the Arguments in the destination fragment
    //navigate to details: private val args: DashboardFragmentArgs by navArgs()
    //Extract data from fragment

    private lateinit var recyclerViewAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //args:view.findViewById<TextView>(R.id.username).text =  "Student Info: ${args.student}"
       // view.findViewById<TextView>(R.id.dashboardFragment).text =  "This is Dashboard"
        val recyclerviewAdapter = MyAdapter()
        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = recyclerviewAdapter

        recyclerViewAdapter =MyAdapter()



    }

}