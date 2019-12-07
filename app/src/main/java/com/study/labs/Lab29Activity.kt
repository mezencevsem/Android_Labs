package com.study.labs

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab29.*

class Lab29Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab29)
        title = "Lab 29 Enum"

        val listAdapter = ArrayAdapter<String>(this, R.layout.list_item_lab5)
        list_view.adapter = listAdapter

        val spinnerAdapter1 = ArrayAdapter<String>(this, R.layout.list_item_lab5)
        spinnerAdapter1.addAll(Sex.Male.name, Sex.Female.name)
        spinner_1.adapter = spinnerAdapter1
        spinner_1.setSelection(0)

        val spinnerAdapter2 = ArrayAdapter<String>(this, R.layout.list_item_lab5)
        spinnerAdapter2.addAll(
            Status.Pupil.name,
            Status.Student.name,
            Status.Worker.name,
            Status.Teacher.name
        )
        spinner_2.adapter = spinnerAdapter2
        spinner_2.setSelection(0)

        button_1.setOnClickListener {
            listAdapter.add(spinner_2.selectedItemPosition.toString())
        }

        button_2.setOnClickListener {
            listAdapter.add(Status.valueOf(spinner_2.getItemAtPosition(spinner_2.selectedItemPosition).toString()).name)
        }

        button_3.setOnClickListener {
            val array = Sex.values()
            var string = ""
            for (item in array) {
                if (string != "") string += ", "
                string += item.name
            }
            listAdapter.add(string)
        }

        button_4.setOnClickListener {
            val array = Status.values()
            var string = ""
            for (item in array) {
                if (string != "") string += ", "
                string += item.name
            }
            listAdapter.add(string)
        }

        button_5.setOnClickListener {
            val person = Person(
                name = edit_text_name.text.toString(),
                age = edit_text_age.text.toString().toInt(),
                sex = Sex.valueOf(spinner_1.selectedItem.toString()),
                status = Status.valueOf(spinner_2.selectedItem.toString())
            )
            listAdapter.add(person.toString())
        }

        button_clear.setOnClickListener {
            listAdapter.clear()
        }
    }
}
