package com.vishal.notekeeper.ui.newnote

import android.text.Editable
import android.text.TextWatcher

abstract class GenericTextWatcher:TextWatcher {
    override fun afterTextChanged(s: Editable?) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int){}
}