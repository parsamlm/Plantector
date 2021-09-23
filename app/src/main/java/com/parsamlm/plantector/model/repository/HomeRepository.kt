package com.parsamlm.plantector.model.repository

import com.parsamlm.plantector.model.Plant
import javax.inject.Inject

class HomeRepository @Inject constructor(){

    fun getPlantList() = Plant.getDefaultFlowerList()
}