package com.study.labs

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DATABASE_NOTEBOOK_VERSION = 10
const val DATABASE_NOTEBOOK_NAME = "notesDB"

const val TABLE_NOTEBOOK_NAME = "notesTable"

const val COLUMN_NOTE_ID = "_id"
const val COLUMN_NOTE_TITLE = "title"
const val COLUMN_NOTE_DESCRIPTION = "description"
const val COLUMN_NOTE_DATE = "date"

class Lab15Database(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE $TABLE_NOTEBOOK_NAME (" +
                    "$COLUMN_NOTE_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NOTE_TITLE TEXT," +
                    "$COLUMN_NOTE_DESCRIPTION TEXT," +
                    "$COLUMN_NOTE_DATE TEXT);"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NOTEBOOK_NAME")
        onCreate(db)
    }
}