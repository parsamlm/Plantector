package com.parsamlm.plantector.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.parsamlm.plantector.model.server.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class PlantDetailsRepository @Inject constructor(private val api: ApiService) {
    private val isErrorOccurred: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    private val plantDescriptionLiveData: MutableLiveData<String> = MutableLiveData<String>()

    init {
        isErrorOccurred.postValue(false)
    }

    fun getPlantDescription(plantName: String): LiveData<String>{
        GlobalScope.launch(Dispatchers.IO){
            try{
                val jsonObject = api.getPlantDescription(plantName)
                plantDescriptionLiveData.postValue(jsonObject.get("extract").asString)
                isErrorOccurred.postValue(false)
            }catch (e : Exception){
                isErrorOccurred.postValue(true)
            }
        }
        return plantDescriptionLiveData
    }

    fun isErrorOccurred(): LiveData<Boolean> = isErrorOccurred

}