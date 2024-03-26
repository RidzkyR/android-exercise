package com.example.android_exercise_3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data (
    val name: String?,
    val age: Int?,

) : Parcelable