package com.study.labs

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_lab22.*

class Lab22Activity : AppCompatActivity() {
    private val notification1: Int = 1
    private val notification2: Int = 2
    private val notification3: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab22)

        button_1.setOnClickListener {
            showNotification(notification1, resources.getString(R.string.mafioznik))
        }

        button_2.setOnClickListener {
            showNotification(notification2, edit_text.text.toString())
        }

        button_3.setOnClickListener {
            showNotification3(notification3, resources.getString(R.string.button_default_text))
        }
    }

    private fun showNotification(id: Int, text: String) {
        val intent = Intent(this, Lab15Activity::class.java)
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val contentIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val view = RemoteViews(packageName, R.layout.notification)
        view.setImageViewResource(R.id.image, R.drawable.image)
        view.setTextViewText(R.id.title, resources.getString(R.string.app_name))
        view.setTextViewText(R.id.description, text)

        val builder = NotificationCompat.Builder(this)
        builder
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(resources.getString(R.string.mafioznik))
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .setTicker("New notification")
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setContent(view)

        val notification = builder.build()
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(id, notification)
    }

    private fun showNotification3(id: Int, text: String) {
        val intent = Intent(this, Lab1Activity::class.java)
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val contentIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val view = RemoteViews(packageName, R.layout.notif)
        view.setImageViewResource(R.id.image, R.drawable.photo)
        view.setTextViewText(R.id.title, resources.getString(R.string.mafioznik))
        view.setTextViewText(R.id.description, text)

        val builder = NotificationCompat.Builder(this)
        builder
            .setSmallIcon(R.drawable.ic_action_name)
            .setContentTitle(resources.getString(R.string.app_name))
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .setTicker("I have something for you")
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setContent(view)

        val notification = builder.build()
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(id, notification)
    }
}
