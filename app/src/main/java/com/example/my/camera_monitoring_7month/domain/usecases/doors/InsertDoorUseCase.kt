package com.example.my.camera_monitoring_7month.domain.usecases.doors


import com.example.my.camera_monitoring_7month.domain.models.DoorModel
import com.example.my.camera_monitoring_7month.domain.repository.DoorRepository
import javax.inject.Inject

class InsertDoorUseCase @Inject constructor(
    private val doorRepository: DoorRepository
) {
    fun insertDoor(doorModel: DoorModel) = doorRepository.insertDoor(doorModel)
}