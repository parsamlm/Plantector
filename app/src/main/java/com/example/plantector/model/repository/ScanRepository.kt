package com.example.plantector.model.repository

import com.example.plantector.model.Plant
import javax.inject.Inject

class ScanRepository @Inject constructor() {

    private val plantList = Plant.getDefaultFlowerList()


    fun getTargetPlant(plantName: String): Plant{
        var targetPlant = Plant("", "", 0)
        for (plant in plantList){
            if(plantName.endsWith(char = 's', ignoreCase = true)){
                val newPlantName = plantName.substring(0, plantName.lastIndex).lowercase()
                if (newPlantName == plant.name.lowercase()){
                    targetPlant = plant
                    targetPlant.name = targetPlant.name.lowercase()
                    break
                }
            }else{
                if (plant.name.lowercase() == plantName){
                    targetPlant = plant
                }
            }

        }
        return targetPlant
    }
}