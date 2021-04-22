package com.example.notes.views

import android.view.View
import android.widget.RadioButton
import com.example.notes.R


fun onRadioButtonClicked(view: View) {
    if (view is RadioButton) {
        // Is the button now checked?
        val checked = view.isChecked

        // Check which radio button was clicked
        when (view.getId()) {
            R.id.radio_masculine ->
                if (checked) {
                    // Il profilo avrà genere maschile
                }
            R.id.radio_feminine ->
                if (checked) {
                    // Il profilo avrà genere femminile
                }
            R.id.radio_other ->
                if (checked) {
                    // Il profilo avrà genere non definito
                }
        }
    }
}

