package com.study.labs

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab25.*

class Lab25Activity : AppCompatActivity() {
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private lateinit var dbHelper: Lab25Database
    private lateinit var cv: ContentValues

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab25)

        arrayAdapter = ArrayAdapter(this, R.layout.list_item_lab5)
        list_view.adapter = arrayAdapter

        dbHelper = Lab25Database(this, DATABASE_NAME, null, DATABASE_VERSION)
        cv = ContentValues()
        val db = dbHelper.writableDatabase

        testInsert(db)

        button_add.setOnClickListener {
            cv.put(COLUMN_NAME, edit_text_name.text.toString())
            cv.put(COLUMN_SURNAME, edit_text_surname.text.toString())
            cv.put(COLUMN_AGE, edit_text_age.text.toString().toInt())

            db.insert(TABLE_NAME, null, cv)
        }

        button_show.setOnClickListener {
            arrayAdapter.clear()
            val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)

            if (cursor.moveToFirst()) {
                do {
                    arrayAdapter.add(
                            cursor.getString(1) + " " +
                            cursor.getString(2) + ", " +
                            cursor.getInt(3) + " y.o.")
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
    }

    private fun testInsert(db: SQLiteDatabase){
        val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
        if (cursor.moveToFirst()) return
        cv.put(COLUMN_NAME, "Name")
        cv.put(COLUMN_SURNAME, "Surname")
        cv.put(COLUMN_AGE, 985)

        db.insert(TABLE_NAME, null, cv)
        cursor.close()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }
}
