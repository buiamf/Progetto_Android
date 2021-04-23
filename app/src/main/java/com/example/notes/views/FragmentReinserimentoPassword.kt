package com.example.notes.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.R
import com.example.notes.databinding.FragmentConfermaBinding
import com.example.notes.databinding.FragmentReinserimentoPasswordBinding
import com.example.notes.utilities.transizioneToLogin

class FragmentReinserimentoPassword : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentReinserimentoPasswordBinding.inflate(layoutInflater)
        with(binding) {
            buttonConfermaNuovaPassword.setOnClickListener { transizioneToLogin(context) }
        }
        return binding.root
        //return inflater.inflate(R.layout.fragment_reinserimento_password, container, false)
    }

}