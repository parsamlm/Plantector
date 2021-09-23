package com.parsamlm.plantector.di

import com.parsamlm.plantector.model.repository.HomeRepository
import com.parsamlm.plantector.model.repository.PlantDetailsRepository
import com.parsamlm.plantector.model.repository.ScanRepository
import com.parsamlm.plantector.model.server.ApiService
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


    @Singleton
    @Provides
    fun provideScanRepository(): ScanRepository = ScanRepository()


    @Singleton
    @Provides
    fun provideHomeRepository(): HomeRepository = HomeRepository()

}