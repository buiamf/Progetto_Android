package com.example.notes.views

import DatabaseAndroid
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.notes.Model.dao.EntityNote
import com.example.notes.Model.dao.EntityUser
import com.example.notes.R
import com.example.notes.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        val db = DatabaseAndroid.getDatabase(this)

           /* GlobalScope.launch {
                db.userDao()
                    .insertUser(EntityUser(1, "pippino@gmial.com", "afacc", "gino", "cose"))
            }
            */

            GlobalScope.launch {
                db.noteDao()
                    .insertNote(EntityNote(1,1,"casna","sbajcbik"))
            }

            setContentView(binding.root)


    }
}