package com.example.androidappdev.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidappdev.R
import com.example.androidappdev.dashboard.DashboardItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the DashboardItem passed from DashboardFragment
        val dashboardItem = arguments?.getParcelable<DashboardItem>("dashboardItem")

        dashboardItem?.let { item ->
            // Bind the item's data to the UI components
            view.findViewById<TextView>(R.id.assetType).text = item.assetType
            view.findViewById<TextView>(R.id.ticker).text = item.ticker
            view.findViewById<TextView>(R.id.currentPrice).text = item.currentPrice.toString()
            view.findViewById<TextView>(R.id.dividendYield).text = item.dividendYield.toString()
            view.findViewById<TextView>(R.id.description).text = item.description
        }
    }
}