package com.example.androidappdev.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Student(val username: String, val password: String): Parcelable
