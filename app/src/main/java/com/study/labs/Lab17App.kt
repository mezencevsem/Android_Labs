package com.study.labs

import android.app.Application
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import java.sql.Time

const val NOTIFICATION_CREATE_NOTE = 200
const val NOTIFICATION_EDIT_NOTE = 202

class Lab17App(
    var text_1: String = "text_1",
    var text_2: String = "text_2",
    var notes: MutableList<Note> = mutableListOf()
) : Application() {

    init {
        notes.add(Note(
            title = "Title",
            description = "Description",
            date = Time(System.currentTimeMillis())))
    }

    fun addNote(title: String, description: String) {
        val toastHelper = Lab20ToastHelper(this)
        notes.add(Note(
            title = title,
            description = description,
            date = Time(System.currentTimeMillis())))
        toastHelper.show(resources.getString(R.string.create_note))
        showNotification(NOTIFICATION_CREATE_NOTE, title, description)
    }

    fun editNote(id: Int, title: String, description: String) {
        val toastHelper = Lab20ToastHelper(this)
        notes.removeAt(id)
        notes.add(id, Note(
            title = title,
            description = description,
            date = Time(System.currentTimeMillis())))
        toastHelper.show(resources.getString(R.string.edit_note))
        showNotification(NOTIFICATION_EDIT_NOTE, title, description)
    }

    private fun showNotification(id: Int, title: String, description: String) {
        val intent = Intent(this, Lab15Activity::class.java)
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val contentIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val view = RemoteViews(packageName, R.layout.notification)
        view.setImageViewResource(R.id.image, R.drawable.image)
        val action: String
        if (id == NOTIFICATION_CREATE_NOTE) action = resources.getString(R.string.create_note)
        else action = resources.getString(R.string.edit_note)
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