package com.example.notes.utilities

import android.app.Activity
import android.content.Intent
import com.example.notes.views.ActivityNavigation

fun Activity.transizioneLogin(activity: Activity) {
    val intent = Intent(activity,ActivityNavigation::class.java)
        startActivity(intent)
}

fun Activity.transizioneRegistrati(activity: Activity) {
    val intent = Intent(activity,ActivityNavigation::class.java)
    startActivity(intent)
}