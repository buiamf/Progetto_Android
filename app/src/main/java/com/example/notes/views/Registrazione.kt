package com.example.notes.views

import android.R.id.message
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.notes.R
import com.example.notes.databinding.ActivityRegistrazioneBinding
import com.example.notes.utilities.transizioneRegistrazioneAvanzata
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Registrazione : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRegistrazioneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.IO) {

            val button = findViewById<Button>(R.id.button_next)
            val email = findViewById<EditText>(R.id.registration_email)
            val password = findViewById<EditText>(R.id.registration_password)
            val reppassword = findViewById<EditText>(R.id.confirm_password)

            button.setOnClickListener {
                val input0: String = email.text.toString()
                Log.d("G", input0.toString())

//                val intent = Intent(
//                    this@Registrazione,
//                    ActivityRegistrazioneAvanzata::class.java
//                )
//                intent.putExtra("message", input0)
//                intent.flags = Intent.


                val pass: String = password.text.toString()
                val reppass: String = reppassword.text.toString()

                Log.d("G", pass.toString())
                Log.d("G", reppass.toString())

                if (pass == reppass) {

                    var emaPass = arrayListOf<String>(input0,pass )
                    val intent = Intent(
                        this@Registrazione,
                        ActivityRegistrazioneAvanzata::class.java
                    )
                    intent.putExtra("message", emaPass)

                   // transizioneRegistrazioneAvanzata(this@Registrazione)
                    startActivity(intent)
                } else {
                    Log.d("G", "errata password confronto")

                }
            }

        }
    }
}