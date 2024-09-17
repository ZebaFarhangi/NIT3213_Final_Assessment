package com.example.androidappdev.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappdev.data.api.DashboardService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.androidappdev.login.RestfulApiRetrofit
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val apiService: DashboardService // Inject the API service directly
) : ViewModel() {

    private val _investmentList = MutableLiveData<List<DashboardItem>>()
    val investmentList: LiveData<List<DashboardItem>> get() = _investmentList

    init {
        fetchInvestments()
    }

    private fun fetchInvestments() {
        viewModelScope.launch {
            try {
                // Call the getDashboardData function with "investment" as the keypass
                val response = apiService.getDashboardData("investment")
                _investmentList.postValue(response.entities)
            } catch (e: Exception) {
                Log.e("DashboardViewModel", "Failed to fetch investments", e)
            }
        }
    }
}
