package com.study.labs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_lab15_second.*
import java.util.*

class Lab15SecondActivity : Lab15BaseActivity() {
    private lateinit var timeDate: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab15_second)
        title = "Edit note"
        timeDate = Calendar.getInstance()

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
            showDialog(1)
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

    override fun onCreateDialog(id: Int): Dialog? {
        when (id) {
            1 -> {
                val ad = AlertDialog.Builder(this)

                val datePickerRoot = layoutInflater.inflate(R.layout.dialog_date, null)
                val datePicker = datePickerRoot?.findViewById<DatePicker>(R.id.date_picker)

                ad.setView(datePickerRoot)
                ad.setTitle("Choice date")
                ad.setCancelable(false)

                ad.setPositiveButton("Choice") { dialog, which ->
                    timeDate.set(datePicker!!.year, datePicker.month, datePicker.dayOfMonth)
                    dialog.cancel()
                    //TimePicker
                    showDialog(2)
                }

                ad.setNegativeButton("Back") { dialog, which ->
                    dialog.cancel()
                }

                return ad.create()
            }
            2 -> {
                val ad = AlertDialog.Builder(this)

                val timePickerRoot = layoutInflater.inflate(R.layout.dialog_time, null)
                val timePicker = timePickerRoot?.findViewById<TimePicker>(R.id.time_picker)
                timePicker?.setIs24HourView(true)

                ad.setView(timePickerRoot)
                ad.setTitle("Choice time")
                ad.setCancelable(false)

                ad.setPositiveButton("Choice") { dialog, which ->
                    timeDate.set(Calendar.HOUR_OF_DAY, timePicker!!.currentHour)
                    timeDate.set(Calendar.MINUTE, timePicker.currentMinute)
                    dialog.cancel()
                    //Done, back to the notes
                    val intent = intent
                    intent.putExtra(
                        EXTRA_Note,
                        Note(
                            title = edit_text_title.text.toString(),
                            description = edit_text_description.text.toString(),
                            date = timeDate.timeInMillis,
                            priority = Priority.valueOf(spinner_priority.selectedItemPosition)
                        )
                    )

                    setResult(RESULT_OK, intent)
                    finish()
                }

                ad.setNegativeButton("Back") { dialog, which ->
                    dialog.cancel()
                }

                return ad.create()
            }
            else -> return null
        }
    }
}
