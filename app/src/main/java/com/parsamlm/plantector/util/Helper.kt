package com.parsamlm.plantector.util

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cesarferreira.tempo.Tempo
import com.google.android.material.snackbar.Snackbar

class Helper {

    companion object {
        fun getTodayDate(): String {
            return Tempo.now.toString().subSequence(0, 10).toString() + ", " + Tempo.now.toString()
                .takeLast(4)
        }


        fun Fragment.showSnackBar(message: String, colorIdResource: Int){
            Snackbar.make(requireView(), message, Snackbar.LENGTH_INDEFINITE).setBackgroundTint(
                ContextCompat.getColor(activity!!, colorIdResource))
                .show()
        }
    }
}