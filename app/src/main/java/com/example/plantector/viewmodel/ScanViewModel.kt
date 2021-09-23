package com.example.plantector.viewmodel

import androidx.lifecycle.ViewModel
import com.example.plantector.model.Plant
import com.example.plantector.model.repository.ScanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor(private val repository: ScanRepository) : ViewModel() {

    fun getTargetPlant(plantName: String): Plant = repository.getTargetPlant(plantName)

}