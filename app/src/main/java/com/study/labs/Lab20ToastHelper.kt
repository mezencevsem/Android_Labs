package com.study.labs

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast

class Lab20ToastHelper(val context: Context) {
    fun show(text: String) {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val textView = layoutInflater.inflate(R.layout.list_item_lab5, null) as TextView
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG

        textView.text = text

        toast.view = textView
        toast.show()
    }
}