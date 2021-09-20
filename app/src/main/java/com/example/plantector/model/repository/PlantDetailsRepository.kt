package com.example.plantector.model.repository

import com.example.plantector.model.server.ApiService
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class PlantDetailsRepository @Inject constructor(private val api: ApiService) {

    fun getPlantDescription(plantName: String): String =
        runBlocking {
            val jsonObject = api.getPlantDescription(plantName)
            return@runBlocking jsonObject.get("extract").asString

        }


}