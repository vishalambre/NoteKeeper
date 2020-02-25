package com.vishal.notekeeper.extensionutils

import java.text.SimpleDateFormat
private const val  dateFormatterTemplate:String = "dd MMMM yyyy, hh:mm a"
fun Long.getFormatterDateTime() : String{
    var date = SimpleDateFormat(dateFormatterTemplate).format(this)
    //As SimpleDate formatter return am/pm in smaller case replace it with uppercase
    date = date.replace("pm","PM")
    date = date.replace("am","AM")
    return date
}