package com.example.androidappdev.login.data

import com.squareup.moshi.Json

data class AddObjectResponse(
    @Json(name = "keypass")val keypass: String
)