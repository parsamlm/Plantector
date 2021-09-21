package com.example.plantector.util

import com.cesarferreira.tempo.Tempo

class Helper {

    companion object{
        fun getDate(): String{
            return Tempo.now.toString().subSequence(0, 10).toString() + "," + Tempo.now.toString()
                .subSequence(29, Tempo.now.toString().length).toString()
        }
    }
}