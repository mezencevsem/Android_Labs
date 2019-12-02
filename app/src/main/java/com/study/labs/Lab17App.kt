package com.study.labs

import android.app.Application
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat

const val NOTIFICATION_CREATE_NOTE = 200
const val NOTIFICATION_EDIT_NOTE = 202

class Lab17App(
    var text_1: String = "text_1",
    var text_2: String = "text_2",
    var notes: ArrayList<String> = ArrayList()
) : Application() {

    init {
        notes.add("Record 1")
        notes.add("Record 2")
    }

    fun addNote(text: String) {
        val toastHelper = Lab20ToastHelper(this)
        notes.add(text)
        toastHelper.show(resources.getString(R.string.create_note))
        showNotification(NOTIFICATION_CREATE_NOTE, text)
    }

    fun editNote(id: Int, text: String) {
        val toastHelper = Lab20ToastHelper(this)
        notes.removeAt(id)
        notes.add(id, text)
        toastHelper.show(resources.getString(R.string.edit_note))
        showNotification(NOTIFICATION_EDIT_NOTE, text)
    }

    private fun showNotification(id: Int, text: String) {
        val intent = Intent(this, Lab15Activity::class.java)
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val contentIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val view = RemoteViews(packageName, R.layout.notification)
        view.setImageViewResource(R.id.image, R.drawable.image)
        val action: String
        if (id == NOTIFICATION_CREATE_NOTE) action = resources.getString(R.string.create_note)
        else action = resources.getString(R.string.edit_note)
        view.setTextViewText(R.id.title, action)
        view.setTextViewText(R.id.description, text)

        val builder = NotificationCompat.Builder(this)
        builder
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(resources.getString(R.string.mafioznik))
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .setTicker("New note action")
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setContent(view)

        val notification = builder.build()
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(id, notification)
    }
}