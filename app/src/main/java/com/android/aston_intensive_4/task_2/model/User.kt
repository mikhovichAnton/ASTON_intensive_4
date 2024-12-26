package com.android.aston_intensive_4.task_2.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var photo: String,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String
) : Parcelable

