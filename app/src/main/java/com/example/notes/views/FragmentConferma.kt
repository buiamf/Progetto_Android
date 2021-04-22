package com.example.notes.views

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.R
import com.example.notes.databinding.FragmentConfermaBinding
import com.example.notes.utilities.transizioneToLogin

class FragmentConferma : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentConfermaBinding.inflate(layoutInflater)
        with(binding) {
            confermaEmailButton.setOnClickListener { transizioneToLogin(context) }
        }
        return binding.root

        //return inflater.inflate(R.layout.fragment_conferma, container, false)
    }


}