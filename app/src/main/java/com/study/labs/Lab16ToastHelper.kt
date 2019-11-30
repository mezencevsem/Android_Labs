package com.study.labs

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class Lab16ToastHelper(val context: Context) {
    fun show(text_1: String, text_2: String) {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = layoutInflater.inflate(R.layout.custom_toast, null)
        val toast = Toast(context)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_LONG

        val text1 = layout.findViewById<TextView>(R.id.text_1)
        text1.text = text_1
        text1.setTextColor(ContextCompat.getColor(context, R.color.colorGreen))
        text1.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPurple))

        val text2 = layout.findViewById<TextView>(R.id.text_2)
        text2.text = text_2
        text2.setTextColor(ContextCompat.getColor(context, R.color.colorBlue))
        text2.setBackgroundColor(ContextCompat.getColor(context, R.color.colorOrange))

        toast.view = layout
        toast.show()
    }
}