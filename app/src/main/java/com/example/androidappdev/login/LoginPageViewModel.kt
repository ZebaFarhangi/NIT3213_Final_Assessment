package com.example.androidappdev.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginPageViewModel:ViewModel() {

    //create  stateflow data type, greetingText is a stateFlow datatype variable
    val greetingText = MutableStateFlow(value = "Hello let's get started!")
    init {
        Log.d("nit3213", "LoginPageViewModel ViewModel was inject")

        viewModelScope.launch {
            delay(300)
            greetingText.value = "Logged in!"
        }


    }

}