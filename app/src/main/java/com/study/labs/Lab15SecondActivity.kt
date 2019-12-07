package com.study.labs

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lab15_second.*
import java.sql.Time

class Lab15SecondActivity : Lab15BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab15_second)
        title = "Edit note"

        val adapter = ArrayAdapter<String>(this, R.layout.list_item_lab5)
        spinner_priority.adapter = adapter
        adapter.addAll(Priority.getItemsArray())
        spinner_priority.setSelection(Priority.Low.ordinal)

        val arg = intent.extras
        if (arg != null) {
            val note = arg.getSerializable(EXTRA_Note) as Note
            edit_text_title.setText(note.title)
            edit_text_description.setText(note.description)
            spinner_priority.setSelection(note.priority.ordinal)
        }

        edit_text_description.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                button_ok.isEnabled = edit_text_description.text.isNotEmpty()
            }
        })

        button_ok.setOnClickListener {
            val intent = intent

            intent.putExtra(
                EXTRA_Note,
                Note(
                    title = edit_text_title.text.toString(),
                    description = edit_text_description.text.toString(),
                    date = Time(System.currentTimeMillis()).toString(),
                    priority = Priority.valueOf(spinner_priority.selectedItemPosition)
                )
            )

            setResult(RESULT_OK, intent)
            finish()
        }

        button_cancel.setOnClickListener {
            setResult(0)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        button_ok.isEnabled = edit_text_description.text.isNotEmpty()
    }
}
