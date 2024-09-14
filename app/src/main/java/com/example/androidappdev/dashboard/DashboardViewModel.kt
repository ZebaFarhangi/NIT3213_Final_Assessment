package com.example.androidappdev.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappdev.RestfulApiRetrofit
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel: ViewModel() {

    private val _greetingText = MutableStateFlow(value = "Hello!")
    //create an instance of class RestfulApiRetrofit
    val restfullApiService = RestfulApiRetrofit().apiService

    init {
        Log.d("nit3213", "Dashboard ViewModel ViewModel was inject")

        // Start updating greeting text without blocking the UI
        viewModelScope.launch {
            delay(3000) // Simulates some task (like loading data)
            val result = restfullApiService.getDashboardData()
            val stringToDisplay = result.map{ item ->
                item.toString() + "\n\n"
            }
            //updateGreetingTextState(stringToDisplay.toString())
        }
    }

    private fun updateGreetingTextState(value: String) {
        _greetingText.value = value
    }

}
