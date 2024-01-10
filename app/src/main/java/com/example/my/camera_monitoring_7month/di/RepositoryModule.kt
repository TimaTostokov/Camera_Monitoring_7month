package com.example.my.camera_monitoring_7month.di

import com.example.my.camera_monitoring_7month.data.repository.CameraRepositoryImpl
import com.example.my.camera_monitoring_7month.data.repository.DoorRepositoryImpl
import com.example.my.camera_monitoring_7month.domain.repository.CameraRepository
import com.example.my.camera_monitoring_7month.domain.repository.DoorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCameraRepository(cameraRepositoryImpl: CameraRepositoryImpl): CameraRepository

    @Binds
    fun bindDoorRepository(doorRepositoryImpl: DoorRepositoryImpl): DoorRepository
}