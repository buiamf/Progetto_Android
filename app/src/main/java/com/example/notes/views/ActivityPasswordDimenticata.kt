package com.example.notes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.notes.R
import com.example.notes.databinding.ActivityPasswordDimenticataBinding

class ActivityPasswordDimenticata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPasswordDimenticataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentManager.commit {
                setReorderingAllowed(true)
                replace<FragmentInserisciEmail>(R.id.fragment_container_password_dimenticata)
            }
        }
    }
}