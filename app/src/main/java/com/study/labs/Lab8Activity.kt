package com.study.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lab8.*

class Lab8Activity : AppCompatActivity() {
    lateinit var arrayAdapter1: ArrayAdapter<String>
    lateinit var arrayAdapter2: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab8)

        arrayAdapter1 = ArrayAdapter(this, R.layout.list_item_lab5)
        arrayAdapter2 = ArrayAdapter(this, R.layout.list_item_lab5)
        list_view1.adapter = arrayAdapter1
        list_view2.adapter = arrayAdapter2

        val list1 = resources.getStringArray(R.array.items1)
        val list2 = resources.getStringArray(R.array.items2)

        for (item in list1) {
            arrayAdapter1.add(item)
        }
        for (item in list2) {
            arrayAdapter2.add(item)
        }

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