package com.example.plantector.viewmodel

import androidx.lifecycle.ViewModel
import com.example.plantector.model.Plant
import com.example.plantector.model.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    fun getPlantList(): List<Plant> = repository.getPlantList()

}