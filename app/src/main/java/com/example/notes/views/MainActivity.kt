package com.example.notes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.notes.R
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.db.DatabaseAndroid
import com.example.notes.model.EntityInformazioni
import com.example.notes.model.EntityUser
import com.example.notes.utilities.*
import com.example.notes.utilities.transizioneLogin
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch {
            val db = DatabaseAndroid.getDatabase(this@MainActivity)
            db.userDao().insert(EntityUser(1, "pippino.it", "pidfso", "pluto", "Luiggino"))
            db.infoDao().insertInformation(EntityInformazioni(1, "M", "padova", "1212", "nfisni"))
            //db.noteDao().insertNote(EntityNote(1, 1, "nuova nota", "isdnaisdiasndiansdiansidn"))
            //db.userDao().deleteUser(EntityUser(2, "pippod.it","pippo","pluto","gino"))
            // val lista = db.userDao().getAll()
            //val pippo = findViewById<TextView>(R.id.utente)

            //pippo.setText("${lista[0].cognome} ")

        }





        with(binding) {
            buttonLogin.setOnClickListener { transizioneLogin(this@MainActivity) }
            buttonRegistrati.setOnClickListener { transizioneRegistrati(this@MainActivity) }
        }


    }

}