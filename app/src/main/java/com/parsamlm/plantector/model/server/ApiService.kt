package com.parsamlm.plantector.model.server

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {

    @Headers("Accept-Language: en-us", "accept: application/json")
    @GET("summary/{plant_name}")
    suspend fun getPlantDescription(@Path("plant_name") plantName: String) : JsonObject

}
