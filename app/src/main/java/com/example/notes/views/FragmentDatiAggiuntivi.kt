package com.example.notes.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.databinding.FragmentDatiAggiuntiviBinding

class FragmentDatiAggiuntivi : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDatiAggiuntiviBinding.inflate(layoutInflater)
        with (binding) {

        }
        return binding.root
        //return inflater.inflate(R.layout.fragment_dati_aggiuntivi, container, false)
    }

}