package com.example.notes.utilities

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.notes.R
import com.example.notes.views.*

fun Activity.transizioneLogin(activity: Activity) {
    val intent = Intent(activity,ActivityNavigation::class.java)
        startActivity(intent)
}

fun Activity.transizioneRegistrati(activity: Activity) {
    val intent = Intent(activity,Registrazione::class.java)
    startActivity(intent)
}

fun Activity.transizionePasswordDimenticata(activity: Activity) {
    val intent = Intent(activity,ActivityPasswordDimenticata::class.java)
    startActivity(intent)
}

fun Activity.transizioneRegistrazioneAvanzata(activity: Activity) {
    val intent = Intent(activity,ActivityRegistrazioneAvanzata::class.java)
    startActivity(intent)
}

fun Fragment.transizioneToLogin(activity: Context?) {
    val intent = Intent(activity,MainActivity::class.java)
    startActivity(intent)
}

fun Fragment.transizioneToConfermaEmail() {
    val fragmentManager = parentFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentManager.commit {
        setReorderingAllowed(true)
        replace<FragmentConferma>(R.id.fragment_container_registrazione)
    }
}

fun Fragment.transizioneToReinserimentoPassword() {
    val fragmentManager = parentFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentManager.commit {
        setReorderingAllowed(true)
        replace<FragmentReinserimentoPassword>(R.id.fragment_container_password_dimenticata)
    }
}