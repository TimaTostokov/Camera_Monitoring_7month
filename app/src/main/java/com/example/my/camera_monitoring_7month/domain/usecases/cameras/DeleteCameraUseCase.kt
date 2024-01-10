package com.example.my.camera_monitoring_7month.domain.usecases.cameras

import com.example.my.camera_monitoring_7month.domain.models.CameraModel
import com.example.my.camera_monitoring_7month.domain.repository.CameraRepository
import javax.inject.Inject

class DeleteCameraUseCase @Inject constructor(
    private val cameraRepository: CameraRepository
) {
    fun deleteCamera(cameraModel: CameraModel) = cameraRepository.deleteCamera(cameraModel)
}