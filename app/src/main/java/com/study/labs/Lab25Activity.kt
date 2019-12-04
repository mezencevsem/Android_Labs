package com.study.labs

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_lab25.*

class Lab25Activity : AppCompatActivity() {
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private lateinit var dbHelper: Lab25Database
    private var editAction: Boolean = false
    private var editId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab25)

        arrayAdapter = ArrayAdapter(this, R.layout.list_item_lab5)
        list_view.adapter = arrayAdapter

        dbHelper = Lab25Database(this, DATABASE_NAME, null, DATABASE_VERSION)
        val db = dbHelper.writableDatabase

        testInsert(db, "Tom", "Cruz", 30)
        testInsert(db, "First", "Second", 666)
        testInsert(db, "Name", "Surname", 27)

        button_add.setOnClickListener {
            val cv = ContentValues()
            cv.put(COLUMN_NAME, edit_text_name.text.toString())
            cv.put(COLUMN_SURNAME, edit_text_surname.text.toString())
            cv.put(COLUMN_AGE, edit_text_age.text.toString().toInt())

            db.insert(TABLE_NAME, null, cv)
        }

        button_show.setOnClickListener {
            val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)

            printList(cursor)

            cursor.close()
        }

        button_search.setOnClickListener {
            val cursor = getSearchCursor(db, "OR")

            printList(cursor)

            cursor.close()
        }

        button_delete.setOnClickListener {
            val cursor = getSearchCursor(db, "AND")

            if (cursor.moveToFirst()) {
                val id = cursor.getInt(0)
                db.delete(TABLE_NAME, "$COLUMN_ID = $id", null)
            }

            cursor.close()
        }

        button_edit.setOnClickListener {
            if (editAction) {
                val name = edit_text_name.text.toString()
                val surname = edit_text_surname.text.toString()
                val age = edit_text_age.text.toString()

                val cv = ContentValues()
                cv.put(COLUMN_NAME, name)
                cv.put(COLUMN_SURNAME, surname)
                cv.put(COLUMN_AGE, age)

                db.update(TABLE_NAME, cv, "$COLUMN_ID = ?", arrayOf(editId.toString()))
                editAction = false

                colorEditTexts(R.color.colorWhite)
            } else {
                val cursor = getSearchCursor(db, "AND")

                if (cursor.moveToFirst()) {
                    editAction = true
                    editId = cursor.getInt(0)

                    colorEditTexts(R.color.colorYellow)
                }

                cursor.close()
            }
        }
    }

    private fun colorEditTexts(color: Int) {
        edit_text_name.setBackgroundColor(ContextCompat.getColor(this, color))
        edit_text_surname.setBackgroundColor(ContextCompat.getColor(this, color))
        edit_text_age.setBackgroundColor(ContextCompat.getColor(this, color))
    }

    private fun printList(cursor: Cursor) {
        arrayAdapter.clear()
        if (cursor.moveToFirst()) {
            do {
                arrayAdapter.add(
                    cursor.getString(1) + " " +
                            cursor.getString(2) + ", " +
                            cursor.getInt(3) + " y.o."
                )
            } while (cursor.moveToNext())
        }
    }

    private fun getSearchCursor(db: SQLiteDatabase, type: String): Cursor {
        val name = edit_text_name.text.toString()
        val surname = edit_text_surname.text.toString()
        val age = edit_text_age.text.toString()

        return db.query(
            TABLE_NAME,
            null,
            "$COLUMN_NAME = ? $type $COLUMN_SURNAME = ? $type $COLUMN_AGE = ?",
            arrayOf(name, surname, age), null, null, null
        )
    }

    private fun testInsert(db: SQLiteDatabase, name: String, surname: String, age: Int) {
        val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
        //if (cursor.moveToFirst()) return
        val cv = ContentValues()
        cv.put(COLUMN_NAME, name)
        cv.put(COLUMN_SURNAME, surname)
        cv.put(COLUMN_AGE, age)

        db.insert(TABLE_NAME, null, cv)
        cursor.close()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.close()
    }
}
