package com.example.notes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.notes.R
import com.example.notes.databinding.ActivityRegistrazioneAvanzataBinding
import com.example.notes.databinding.ActivityRegistrazioneBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityRegistrazioneAvanzata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRegistrazioneAvanzataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.IO) {

            val button = findViewById<Button>(R.id.register_button)

            val nome = findViewById<EditText>(R.id.nome_registrazione)
            val cognome = findViewById<EditText>(R.id.cognome_registrazione)
            val data = findViewById<EditText>(R.id.data_di_nascita_registrazione)
            val luogo = findViewById<EditText>(R.id.luogo_di_nascita_registrazione)
           // val genere = findViewById<RadioGroup>(R.id.genere_regitrazione)


            button.setOnClickListener {

                val input0: String = nome.text.toString()
                val input1: String = cognome.text.toString()


            }



        }




        with(binding) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentManager.commit {
                setReorderingAllowed(true)
                replace<FragmentDatiAggiuntivi>(R.id.fragment_container_registrazione)
            }
        }



    }
}