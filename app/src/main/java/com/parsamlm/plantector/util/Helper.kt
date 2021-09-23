package com.parsamlm.plantector.util

import com.cesarferreira.tempo.Tempo

class Helper {

    companion object {
        fun getTodayDate(): String {
            return Tempo.now.toString().subSequence(0, 10).toString() + "," + Tempo.now.toString()
                .subSequence(29, Tempo.now.toString().length).toString()
        }
    }
}