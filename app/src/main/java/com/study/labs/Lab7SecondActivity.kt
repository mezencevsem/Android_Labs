package com.study.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lab7_second.*

class Lab7SecondActivity : AppCompatActivity() {
    lateinit var arrayAdapter1: ArrayAdapter<String>
    lateinit var arrayAdapter2: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab7_second)

        arrayAdapter1 = ArrayAdapter(this, R.layout.list_item_lab5)
        arrayAdapter2 = ArrayAdapter(this, R.layout.list_item_lab5)
        list_view1.adapter = arrayAdapter1
        list_view2.adapter = arrayAdapter2

        button_add_to_list1.setOnClickListener {
            arrayAdapter1.add(edit_text.text.toString())
        }

        button_add_to_list2.setOnClickListener {
            arrayAdapter2.add(edit_text.text.toString())
        }

        button_back.setOnClickListener {
            onBackPressed()
        }
    }
}
