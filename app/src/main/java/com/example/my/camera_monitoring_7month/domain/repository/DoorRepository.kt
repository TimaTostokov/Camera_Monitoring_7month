package com.example.my.camera_monitoring_7month.domain.repository

import com.example.my.camera_monitoring_7month.domain.models.DoorModel
import com.example.my.camera_monitoring_7month.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DoorRepository {

    suspend fun getRemoteDoors(): Flow<Resource<List<DoorModel>>>

    fun getLocalDoors(): List<DoorModel>

    fun insertDoor(doorModel: DoorModel)

    fun insertLocalDoors(doorModels: List<DoorModel>)

    fun updateDoor(doorModel: DoorModel)

    fun updateLocalDoors(doorModels: List<DoorModel>)

    fun deleteDoor(doorModel: DoorModel)
}