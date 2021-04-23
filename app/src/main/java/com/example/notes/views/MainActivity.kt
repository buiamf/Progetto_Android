package com.example.notes.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.notes.R
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.db.DatabaseAndroid
import com.example.notes.model.EntityInformazioni
import com.example.notes.model.EntityUser
import com.example.notes.utilities.*
import com.example.notes.utilities.transizioneLogin
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        GlobalScope.launch(Dispatchers.IO) {
            //val db = DatabaseAndroid.getDatabase(this@MainActivity)
            //db.userDao().insert(EntityUser(1, "pippino.it", "ciccio", "pluto", "Luiggino"))

            val button = findViewById<Button>(R.id.button_login)
            val email = findViewById<EditText>(R.id.text_email)
            val password = findViewById<EditText>(R.id.text_password)

            button.setOnClickListener {

                val input0: String = email.text.toString()
                val input1: String = password.text.toString()
                //Log.d("G", input0.toString())
                //Log.d("G", input1.toString())
                GlobalScope.launch {
                    val db = DatabaseAndroid.getDatabase(this@MainActivity)
                    val email: List<String> = db.userDao().getAllEmail()
                    val password: List<String> = db.userDao().getAllPassword()

                    val intent = Intent(
                        this@MainActivity,
                        ActivityNavigation::class.java
                    )
                    intent.putExtra("message", input0)

                    // transizioneRegistrazioneAvanzata(this@Registrazione)




                    val ema = email.indexOf(input0)
                    //Log.d("P", ema.toString())
                    val pas = password.indexOf(input1)
                    // Log.d("P", pas.toString())

                    when {
                        db.userDao()
                            .checkPassword(input0, input1) -> startActivity(intent) //transizioneLogin(this@MainActivity)
                        !db.userDao().checkEmail(input0) -> Log.d("P", "Email non corretta")
                        else -> Log.d("P", "Password non corretta")
                    }

                }

            }


        }


        with(binding) {
            buttonRegistrati.setOnClickListener { transizioneRegistrati(this@MainActivity) }
        }


    }

}