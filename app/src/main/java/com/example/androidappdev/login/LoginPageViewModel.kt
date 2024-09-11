package com.example.androidappdev.login

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginPageViewModel:ViewModel() {

    //used data type stateflow
    val greetingText = MutableStateFlow(value = "Hi everyone!")
    init {
        Log.d("nit3213", "LoginPageViewModel ViewModel was inject")
        greetingText.value = "Hi everyone 001"
    }

}