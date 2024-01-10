package com.example.my.camera_monitoring_7month.domain.usecases.cameras

import com.example.my.camera_monitoring_7month.domain.models.CameraModel
import com.example.my.camera_monitoring_7month.domain.repository.CameraRepository
import javax.inject.Inject

class InsertCameraUseCase @Inject constructor(
    private val cameraRepository: CameraRepository
) {
    fun insertCamera(cameraModel: CameraModel) = cameraRepository.insertCamera(cameraModel)
}