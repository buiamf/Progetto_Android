package com.example.notes.views

import DatabaseAndroid
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.notes.Model.dao.EntityNote
import com.example.notes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)


        /* GlobalScope.launch {
             db.userDao()
                 .insertUser(EntityUser(1, "pippino@gmial.com", "afacc", "gino", "cose"))
         }
         */

        lifecycleScope.launchWhenResumed {
            val db = DatabaseAndroid.getDatabase(this@MainActivity)
            db.noteDao()!!.insertNote(EntityNote(0, 0, "casna", "sbajcbik"))
        }

        setContentView(binding.root)


    }
}