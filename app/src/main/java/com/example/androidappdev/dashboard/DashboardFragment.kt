package com.example.androidappdev.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidappdev.R
//import com.example.androidappdev.dashboard.data.model.DashboardService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private lateinit var dashboardAdapter: DashboardAdapter
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dashboardAdapter = DashboardAdapter { dashboardItem ->
            // Handle item click, navigate to details
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(dashboardItem)
            findNavController().navigate(action)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = dashboardAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Observe investmentList from the ViewModel
        viewModel.investmentList.observe(viewLifecycleOwner) { investments ->
            dashboardAdapter.submitList(investments)
        }
    }
}
