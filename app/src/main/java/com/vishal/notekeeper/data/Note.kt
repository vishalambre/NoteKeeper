package com.vishal.notekeeper.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note(
    val title: String,
    val description: String,
    val timeStamp: Long = System.currentTimeMillis()
) : Parcelable