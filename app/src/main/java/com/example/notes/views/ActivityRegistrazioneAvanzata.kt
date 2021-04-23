package com.example.notes.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.notes.R
import com.example.notes.databinding.ActivityRegistrazioneAvanzataBinding


class ActivityRegistrazioneAvanzata : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = getIntent().extras?.getStringArrayList("message")

//        if (message != null) {
//            Log.d("Pfsdf", message)
//        }

        val bundle = Bundle()
        bundle.putStringArrayList("edttext", message)
        val fragobj = FragmentDatiAggiuntivi()
        fragobj.arguments = bundle
        Log.d("Pff", fragobj.arguments.toString())


        val binding = ActivityRegistrazioneAvanzataBinding.inflate(layoutInflater)
        setContentView(binding.root)





        with(binding) {
            val fragmentManager = supportFragmentManager

            val fragmentTransaction = fragmentManager.beginTransaction()

           fragmentManager.commit {
               setReorderingAllowed(true)
              replace(R.id.fragment_container_registrazione,fragobj)
            }
        }



    }
}