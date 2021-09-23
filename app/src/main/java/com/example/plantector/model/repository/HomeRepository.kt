package com.example.plantector.model.repository

import com.example.plantector.model.Plant
import javax.inject.Inject

class HomeRepository @Inject constructor(){

    fun getPlantList() = Plant.getDefaultFlowerList()
}