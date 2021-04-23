package com.example.notes.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.R
import com.example.notes.databinding.FragmentDatiAggiuntiviBinding
import com.example.notes.databinding.FragmentInserisciEmailBinding
import com.example.notes.utilities.transizioneToConfermaEmail
import com.example.notes.utilities.transizioneToLogin
import com.example.notes.utilities.transizioneToReinserimentoPassword

class FragmentInserisciEmail : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInserisciEmailBinding.inflate(layoutInflater)
        with(binding) {
            inviaCodiceButton.setOnClickListener {
                transizioneToReinserimentoPassword()
            }
            annullaRecupero.setOnClickListener { transizioneToLogin(context) }
        }
        return binding.root
        //return inflater.inflate(R.layout.fragment_inserisci_email, container, false)
    }

}