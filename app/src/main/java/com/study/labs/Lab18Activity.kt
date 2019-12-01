package com.study.labs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab18.*

class Lab18Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab18)

        button_1.setOnClickListener {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val textView = inflater.inflate(R.layout.list_item_lab5, null) as TextView

            textView.text = edit_text_1.text.toString()

            list_layout.addView(textView)
        }

        button_2.setOnClickListener {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val root = inflater.inflate(R.layout.list_item_lab18, null) as LinearLayout

            val textViewName = root.findViewById<TextView>(R.id.name_text)
            textViewName.text = "Name: ${edit_text_1.text}"

            val textViewAge = root.findViewById<TextView>(R.id.age_text)
            textViewAge.text = "Age: ${edit_text_2.text}"

            list_layout.addView(root)
        }
    }
}
