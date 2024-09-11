package com.example.androidappdev.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginPageViewModel:ViewModel() {

    //create  stateflow data type, greetingText is a stateFlow datatype variable
    private val greetingText = MutableStateFlow(value = "Hello let's get started!")

    val greetingTextState:StateFlow<String> = greetingText

    init {
        Log.d("nit3213", "LoginPageViewModel ViewModel was inject")

        viewModelScope.launch {
            delay(3000)
            updateGreetingTextState("Log in!")
        }


    }
    fun updateGreetingTextState(value: String){
        greetingText.value = value
    }

}