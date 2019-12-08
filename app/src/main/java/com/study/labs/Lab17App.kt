package com.study.labs

import android.app.Application
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat

const val NOTIFICATION_CREATE_NOTE = 200
const val NOTIFICATION_EDIT_NOTE = 202

class Lab17App(
    var text_1: String = "text_1",
    var text_2: String = "text_2",
    var notes: MutableList<Note> = mutableListOf()
) : Application() {
    private lateinit var dbHelper: Lab15Database
    private lateinit var db: SQLiteDatabase

    override fun onCreate() {
        super.onCreate()
        dbHelper = Lab15Database(this, DATABASE_NOTEBOOK_NAME, null, DATABASE_NOTEBOOK_VERSION)
        db = dbHelper.writableDatabase
    }

    fun testInsert(title: String, description: String, date: Long, priority: Priority) {
        val cursor = db.query(TABLE_NOTEBOOK_NAME, null, null, null, null, null, null)
        if (cursor.moveToFirst()) return
        val cv = ContentValues()
        cv.put(COLUMN_NOTE_TITLE, title)
        cv.put(COLUMN_NOTE_DESCRIPTION, description)
        cv.put(COLUMN_NOTE_DATE, date)
        cv.put(COLUMN_NOTE_PRIORITY, priority.ordinal)

        db.insert(TABLE_NOTEBOOK_NAME, null, cv)
        cursor.close()
    }

    fun showAllNotes() {
        notes.clear()

        val cursor = db.query(TABLE_NOTEBOOK_NAME, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                notes.add(
                    Note(
                        title = cursor.getString(1),
                        description = cursor.getString(2),
                        date = cursor.getLong(3),
                        priority = Priority.valueOf(cursor.getInt(4))
                    )
                )
            } while (cursor.moveToNext())
        }

        cursor.close()
    }

    fun addNote(title: String, description: String, priority: Priority) {
        val toastHelper = Lab20ToastHelper(this)

        val cv = ContentValues()
        cv.put(COLUMN_NOTE_TITLE, title)
        cv.put(COLUMN_NOTE_DESCRIPTION, description)
        cv.put(COLUMN_NOTE_DATE, System.currentTimeMillis())
        cv.put(COLUMN_NOTE_PRIORITY, priority.ordinal)

        db.insert(TABLE_NOTEBOOK_NAME, null, cv)

        toastHelper.show(resources.getString(R.string.create_note))
        showNotification(NOTIFICATION_CREATE_NOTE, title, description)
    }

    fun getNoteId(title: String, description: String, priority: Priority): Int? {
        //TODO date
        val cursor = db.query(
            TABLE_NOTEBOOK_NAME,
            null,
            "$COLUMN_NOTE_TITLE = ? " +
                    "AND $COLUMN_NOTE_DESCRIPTION = ? " +
                    "AND $COLUMN_NOTE_PRIORITY = ?",
            arrayOf(title, description, priority.ordinal.toString()),
            null,
            null,
            null
        )

        if (cursor.moveToFirst()) {
            val editId = cursor.getInt(0)
            cursor.close()
            return editId
        }
        cursor.close()
        return null
    }

    fun editNote(editId: Int, title: String, description: String, priority: Priority) {
        val toastHelper = Lab20ToastHelper(this)

        val cv = ContentValues()
        cv.put(COLUMN_NOTE_TITLE, title)
        cv.put(COLUMN_NOTE_DESCRIPTION, description)
        cv.put(COLUMN_NOTE_DATE, System.currentTimeMillis())
        cv.put(COLUMN_NOTE_PRIORITY, priority.ordinal)

        db.update(TABLE_NOTEBOOK_NAME, cv, "$COLUMN_NOTE_ID = ?", arrayOf(editId.toString()))

        toastHelper.show(resources.getString(R.string.edit_note))
        showNotification(NOTIFICATION_EDIT_NOTE, title, description)
    }

    private fun showNotification(id: Int, title: String, description: String) {
        val intent = Intent(this, Lab15Activity::class.java)
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val contentIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val view = RemoteViews(packageName, R.layout.notification)
        view.setImageViewResource(R.id.image, R.drawable.notes)
        val action: String =
            if (id == NOTIFICATION_CREATE_NOTE) resources.getString(R.string.create_note)
            else resources.getString(R.string.edit_note)
        view.setTextViewText(R.id.title, title)
        view.setTextViewText(R.id.description, description)

        val builder = NotificationCompat.Builder(this)
        builder
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(resources.getString(R.string.app_name))
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .setTicker(action)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setContent(view)

        val notification = builder.build()
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(id, notification)
    }
}