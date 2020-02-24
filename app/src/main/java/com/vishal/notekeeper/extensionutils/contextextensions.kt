package com.vishal.notekeeper.extensionutils

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T: Activity> Context.startActivity(){
    startActivity(intent<T>())
}
inline fun <reified T:Activity> Context.intent() =  Intent(this,T::class.java)
