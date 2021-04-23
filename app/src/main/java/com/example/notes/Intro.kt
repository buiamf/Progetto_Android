package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.animation.doOnRepeat
import com.example.notes.databinding.ActivityIntroBinding
import com.example.notes.views.MainActivity

class Intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityIntroBinding.inflate(layoutInflater)
        val intent = Intent(this, MainActivity::class.java)

        supportActionBar!!.hide()
        setContentView(binding.root)
        binding.animationView.addAnimatorUpdateListener {
            it.doOnRepeat {
                Log.d("t", "funza")
                startActivity(intent)
            }
        }



    }
}