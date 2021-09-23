package com.parsamlm.plantector.viewmodel

import androidx.lifecycle.ViewModel
import com.parsamlm.plantector.model.Plant
import com.parsamlm.plantector.model.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    fun getPlantList(): List<Plant> = repository.getPlantList()

}