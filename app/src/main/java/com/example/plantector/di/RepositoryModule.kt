package com.example.plantector.di

import com.example.plantector.model.repository.PlantDetailsRepository
import com.example.plantector.model.server.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePlantDetailsRepository(api: ApiService): PlantDetailsRepository =
        PlantDetailsRepository(api)
}