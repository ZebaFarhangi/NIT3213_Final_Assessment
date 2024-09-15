package com.example.androidappdev.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappdev.dashboard.network.DashboardApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
@HiltViewModel
class LoginPageViewModel: ViewModel() {

    private val _greetingText = MutableStateFlow(value = "Hello let's get started!")
    val greetingTextState: StateFlow<String> = _greetingText
    //private val restfullApiService = RestfulApiRetrofit().apiService

    init {
        Log.d("nit3213", "LoginPageViewModel ViewModel was inject")

        // Start updating greeting text without blocking the UI
        viewModelScope.launch {
            delay(3000) // Simulates some task (like loading data)
            updateGreetingTextState("Log in!")
        }
    }

    private fun updateGreetingTextState(value: String) {
        _greetingText.value = value
    }

    // Example of performing a network login operation asynchronously
    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                // Simulate a long-running network call
                val loginResult = simulateLoginNetworkCall(username, password)
                //val result = restfullApiService.addObject(username = )

                // Update UI state based on the login result
                if (loginResult) {
                    updateGreetingTextState("Login Successful!")
                } else {
                    updateGreetingTextState("Login Failed!")
                }
            } catch (e: Exception) {
                // Handle exceptions (e.g., network errors)
                Log.e("LoginPageViewModel", "Login failed", e)
                updateGreetingTextState("Error during login.")
            }
        }
    }

    // Simulate a long-running network call
     private suspend fun simulateLoginNetworkCall(username: String, password: String): Boolean {
        delay(2000) // Simulating a delay (network call)
        return username == "Zeba" && password == "s4604460"
    }
    //val apiService: DashboardApiService = retrofit.create(DashboardApiService::class.java)
}
