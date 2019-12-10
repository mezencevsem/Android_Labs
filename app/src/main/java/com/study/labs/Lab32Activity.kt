package com.study.labs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab32.*

const val DIALOG_ID_1 = 1
const val DIALOG_ID_2 = 2
const val DIALOG_ID_3 = 3
const val DIALOG_ID_4 = 4
const val DIALOG_ID_5 = 5

class Lab32Activity : AppCompatActivity() {
    private lateinit var ad: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab32)

        button_1.setOnClickListener {
            showDialog(DIALOG_ID_1)
        }

        button_2.setOnClickListener {
            showDialog(DIALOG_ID_2)
        }

        button_3.setOnClickListener {
            showDialog(DIALOG_ID_3)
        }

        button_4.setOnClickListener {
            showDialog(DIALOG_ID_4)
        }

        button_5.setOnClickListener {
            showDialog(DIALOG_ID_5)
        }
    }

    override fun onCreateDialog(id: Int): Dialog? {
        when (id) {
            DIALOG_ID_1 -> {
                val array = arrayOf("Red", "Green", "Blue")
                ad = AlertDialog.Builder(this)
                ad.setTitle("Choice item")
                ad.setItems(array) { dialog, item ->
                    text_view.text = array[item]
                }
                ad.setCancelable(false)
                return ad.create()
            }
            DIALOG_ID_2 -> {
                val array = arrayOf("Red", "Green", "Blue")
                var choiceId = -1
                ad = AlertDialog.Builder(this)
                ad.setTitle("Choice item")
                ad.setCancelable(false)
                ad.setPositiveButton("Ok") { dialog, which ->
                    if (choiceId != -1) {
                        text_view.text = array[choiceId]
                    }
                    dialog.cancel()
                }
                ad.setNegativeButton("Back") { dialog, which ->
                    dialog.cancel()
                }
                ad.setSingleChoiceItems(array, -1) { dialog, item ->
                    choiceId = item
                }
                return ad.create()
            }
            DIALOG_ID_3 -> {
                val array = arrayOf("Red", "Green", "Blue")
                val checkedItems = BooleanArray(3)
                checkedItems[0] = false
                checkedItems[1] = false
                checkedItems[2] = false
                ad = AlertDialog.Builder(this)
                ad.setTitle("Choice items")
                ad.setCancelable(false)
                ad.setPositiveButton("Done") { dialog, which ->
                    var string = ""
                    for (i in array.indices) {
                        if (checkedItems[i]) string += array[i] + " "
                    }
                    text_view.text = string
                    dialog.cancel()
                }
                ad.setNegativeButton("Back") { dialog, which ->
                    dialog.cancel()
                }
                ad.setMultiChoiceItems(array, checkedItems) { dialog, item, isChecked ->
                    checkedItems[item] = isChecked
                }
                return ad.create()
            }
            DIALOG_ID_4 -> {
                ad = AlertDialog.Builder(this)

                val root = layoutInflater.inflate(R.layout.dialog_person, null)
                val name = root?.findViewById<EditText>(R.id.edit_text_name)
                val age = root?.findViewById<EditText>(R.id.edit_text_age)
                val spinnerSex = root?.findViewById<Spinner>(R.id.spinner_sex)
                val spinnerStatus = root?.findViewById<Spinner>(R.id.spinner_status)

                val adapterSex = ArrayAdapter<String>(this, R.layout.list_item_lab5)
                adapterSex.addAll(Sex.Male.name, Sex.Female.name)
                spinnerSex?.adapter = adapterSex
                spinnerSex?.setSelection(0)

                val adapterStatus = ArrayAdapter<String>(this, R.layout.list_item_lab5)
                adapterStatus.addAll(
                    Status.Pupil.name,
                    Status.Student.name,
                    Status.Worker.name,
                    Status.Teacher.name
                )
                spinnerStatus?.adapter = adapterStatus
                spinnerStatus?.setSelection(0)

                ad.setView(root)

                ad.setTitle("Create Person")
                ad.setCancelable(false)
                ad.setPositiveButton("Done") { dialog, which ->
                    val person = Person(
                        name = name?.text.toString(),
                        age = age?.text.toString().toInt(),
                        sex = Sex.valueOf(spinnerSex?.selectedItem.toString()),
                        status = Status.valueOf(spinnerStatus?.selectedItem.toString())
                    )

                    text_view.text = person.toString()
                    dialog.cancel()
                }
                ad.setNegativeButton("Back") { dialog, which ->
                    dialog.cancel()
                }

                return ad.create()
            }
            DIALOG_ID_5 -> {
                ad = AlertDialog.Builder(this)

                val datePickerRoot = layoutInflater.inflate(R.layout.dialog_date, null)
                val datePicker = datePickerRoot?.findViewById<DatePicker>(R.id.date_picker)

                ad.setView(datePickerRoot)
                ad.setTitle("Choice date")
                ad.setCancelable(true)

                ad.setPositiveButton("Choice") { dialog, which ->
                    text_view.text =
                        "${datePicker?.dayOfMonth}.${datePicker?.month?.plus(1)}.${datePicker?.year}"
                    dialog.cancel()
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
