package com.example.notes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.notes.R
import com.example.notes.databinding.ActivityRegistrazioneBinding
import com.example.notes.utilities.transizioneRegistrazioneAvanzata

class Registrazione : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityRegistrazioneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonNext.setOnClickListener { transizioneRegistrazioneAvanzata(this@Registrazione) }
        }
    }
}