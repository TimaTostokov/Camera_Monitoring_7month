package com.example.my.camera_monitoring_7month.domain.usecases.doors

import com.example.my.camera_monitoring_7month.domain.models.DoorModel
import com.example.my.camera_monitoring_7month.domain.repository.DoorRepository
import javax.inject.Inject

class UpdateDoorUseCase @Inject constructor(
    private val doorRepository: DoorRepository
) {
    fun updateDoor(doorModel: DoorModel) = doorRepository.updateDoor(doorModel)
}