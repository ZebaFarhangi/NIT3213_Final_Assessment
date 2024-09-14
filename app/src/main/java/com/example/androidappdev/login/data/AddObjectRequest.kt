package com.example.androidappdev.login.data

import com.squareup.moshi.Json

data class AddObjectRequest(
    @Json(name = "username") val username: String,
    @Json(name = "password")val password: String
)