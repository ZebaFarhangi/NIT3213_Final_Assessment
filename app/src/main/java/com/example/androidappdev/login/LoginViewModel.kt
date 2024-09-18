package com.example.androidappdev.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidappdev.login.LoginRequest
import com.example.androidappdev.data.api.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val restfulApiRetrofit: RestfulApiRetrofit
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(username: String, password: String) {
        _loginState.value = LoginState.Loading

        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(username, password)
                val response = restfulApiRetrofit.apiService.login(loginRequest) // Correct usage of RestfulApiRetrofit

                if (response.keypass.isNotEmpty()) {
                    _loginState.value = LoginState.Success(response.keypass)
                } else {
                    _loginState.value = LoginState.Error("Invalid login credentials")
                }
            } catch (e: Exception) {
                Log.e("LoginViewModel", "Login failed", e)
                _loginState.value = LoginState.Error("Failed to log in: ${e.message}")
            }
        }
    }
}


sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val keypass: String) : LoginState()
    data class Error(val message: String) : LoginState()
}






