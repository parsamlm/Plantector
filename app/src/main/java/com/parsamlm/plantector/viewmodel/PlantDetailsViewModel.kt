package com.parsamlm.plantector.viewmodel

import androidx.lifecycle.ViewModel
import com.parsamlm.plantector.model.repository.PlantDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlantDetailsViewModel @Inject constructor(private val plantDetailsRepository: PlantDetailsRepository) :
    ViewModel() {

    fun getPlantDescription(plantName: String): String =
        plantDetailsRepository.getPlantDescription(plantName)

}