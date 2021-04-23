package com.example.notes.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.databinding.FragmentDatiAggiuntiviBinding
import com.example.notes.db.DatabaseAndroid
import com.example.notes.model.EntityInformazioni
import com.example.notes.model.EntityUser
import com.example.notes.utilities.transizioneToConfermaEmail
import com.example.notes.utilities.transizioneToLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FragmentDatiAggiuntivi : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDatiAggiuntiviBinding.inflate(layoutInflater)


        val emaPass = arguments?.getStringArrayList("edttext")

        Log.d("Pdsdsdsdsdsdsds", emaPass.toString())

        GlobalScope.launch(Dispatchers.IO) {


            val button = binding.registerButton
            val skip = binding.skipDati
            val nome = binding.nomeRegistrazione
            val cognome = binding.cognomeRegistrazione
            val data = binding.dataDiNascitaRegistrazione
            val luogo = binding.luogoDiNascitaRegistrazione
            var genere = "Non Definito"
            val maschile = binding.radioMasculine
            val femm = binding.radioFeminine
            val altro = binding.radioOther
            maschile.setOnClickListener { genere = onRadioButtonClicked(maschile) }
            femm.setOnClickListener { genere = onRadioButtonClicked(femm) }
            altro.setOnClickListener { genere = onRadioButtonClicked(altro) }

            val n: String = nome.text.toString()
            val c: String = cognome.text.toString()
            val d: String = data.text.toString()
            val l: String = luogo.text.toString()


            button.setOnClickListener {

                GlobalScope.launch {
                    val db = DatabaseAndroid.getDatabase(requireContext())
                    Log.d("bdsjbfsjdn", genere)

                    if (emaPass != null) {

                        db.userDao().insert(
                            EntityUser(
                                email = emaPass[0], password = emaPass[1], nome = n, cognome = c
                            )
                        )


                        db.infoDao().insertInformation(
                            EntityInformazioni(
                                genere = genere,
                                luogo = l,
                                data = d
                            )
                        )

                    }

                    startActivity(Intent(activity,MainActivity::class.java))
                }

            }

            skip.setOnClickListener{

                GlobalScope.launch {
                    val db = DatabaseAndroid.getDatabase(requireContext())
                    Log.d("bdsjbfsjdn", genere)

                    if (emaPass != null) {

                        db.userDao().insert(
                            EntityUser(
                                email = emaPass[0], password = emaPass[1], nome = " ", cognome = " "
                            )
                        )


                        db.infoDao().insertInformation(
                            EntityInformazioni(
                                genere = " ",
                                luogo = " ",
                                data = " "
                            )
                        )

                    }

                    startActivity(Intent(activity,MainActivity::class.java))
                }

            }

        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_dati_aggiuntivi, container, false)
    }

    fun onRadioButtonClicked(view: View): String {

        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_masculine ->
                    if (checked) {
                        return "M"
                        // Il profilo avrà genere maschile
                    }
                R.id.radio_feminine ->
                    if (checked) {
                        // Il profilo avrà genere femminile
                        return "F"
                    }
                R.id.radio_other ->
                    if (checked) {
                        return "Altro"
                        // Il profilo avrà genere non definito
                    }
            }
        }
        return "Non Definito"
    }


}


