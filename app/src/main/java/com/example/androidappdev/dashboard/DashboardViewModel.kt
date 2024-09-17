package com.example.androidappdev.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.androidappdev.login.RestfulApiRetrofit
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val apiService: RestfulApiRetrofit
) : ViewModel() {

    private val _investmentList = MutableLiveData<List<DashboardItem>>()
    val investmentList: LiveData<List<DashboardItem>> get() = _investmentList

    init {
        fetchInvestments()
    }

    private fun fetchInvestments() {
        viewModelScope.launch {
            try {
                val response = apiService.apiService.getDashboardData("investments")
                _investmentList.postValue(response.entities)
            } catch (e: Exception) {
                Log.e("DashboardViewModel", "Failed to fetch investments", e)
            }
        }
    }
}



