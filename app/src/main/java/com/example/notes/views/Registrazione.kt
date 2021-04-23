package com.example.notes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.commit
import androidx.fragment.app.replace
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
                val pass: String = password.text.toString()
                val reppass: String = reppassword.text.toString()

                Log.d("G", pass.toString())
                Log.d("G", reppass.toString())

                if (pass == reppass) {

                    transizioneRegistrazioneAvanzata(this@Registrazione)

                } else {
                    Log.d("G", "errata password confronto")

                }
            }

        }
    }
}