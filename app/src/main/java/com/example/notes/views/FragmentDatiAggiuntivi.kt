package com.example.notes.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.notes.R
import com.example.notes.databinding.ActivityRegistrazioneAvanzataBinding
import com.example.notes.databinding.FragmentDatiAggiuntiviBinding
import com.example.notes.utilities.transizioneToConfermaEmail

class FragmentDatiAggiuntivi : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDatiAggiuntiviBinding.inflate(layoutInflater)
        with(binding) {
            registerButton.setOnClickListener {
                transizioneToConfermaEmail()
            }
            skipDati.setOnClickListener { transizioneToConfermaEmail() }
        }
        return binding.root
        //return inflater.inflate(R.layout.fragment_dati_aggiuntivi, container, false)
    }

}