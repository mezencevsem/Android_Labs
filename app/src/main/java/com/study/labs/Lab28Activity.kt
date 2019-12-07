package com.study.labs

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab28.*

class Lab28Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab28)
        title = "Lab 28 Spinner"

        val listAdapter = ArrayAdapter<String>(this, R.layout.list_item_lab5)
        list_view.adapter = listAdapter

        val spinnerAdapter1 = ArrayAdapter<String>(this, R.layout.list_item_lab5)
        spinnerAdapter1.addAll("Item 1.1", "Item 1.2", "Item 1.3", "Item 1.4")
        spinner_1.adapter = spinnerAdapter1
        spinner_1.setSelection(0)

        val spinnerAdapter2 = ArrayAdapter<String>(this, R.layout.list_item_lab5)
        spinnerAdapter2.addAll("Item 2.1", "Item 2.2", "Item 2.3", "Item 2.4")
        spinner_2.adapter = spinnerAdapter2
        spinner_2.setSelection(0)

        button_1.setOnClickListener {
            listAdapter.add(spinner_1.selectedItem.toString())
        }

        button_2.setOnClickListener {
            listAdapter.add(spinner_2.selectedItem.toString())
        }
    }
}
