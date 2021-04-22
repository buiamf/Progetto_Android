package com.example.notes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.notes.R
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.utilities.*
import com.example.notes.utilities.transizioneLogin


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonLogin.setOnClickListener { transizioneLogin(this@MainActivity) }
            buttonRegistrati.setOnClickListener { transizioneRegistrati(this@MainActivity) }
        }


    }

}