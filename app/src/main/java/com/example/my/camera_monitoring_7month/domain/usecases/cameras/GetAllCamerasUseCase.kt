package com.example.my.camera_monitoring_7month.domain.usecases.cameras

import com.example.my.camera_monitoring_7month.domain.models.CameraModel
import com.example.my.camera_monitoring_7month.domain.repository.CameraRepository
import com.example.my.camera_monitoring_7month.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCamerasUseCase @Inject constructor(
    private val cameraRepository: CameraRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<CameraModel>>> {
        val data = cameraRepository.getLocalCameras()
        if (data.isEmpty()) {
            cameraRepository.getRemoteCameras().collect {
                if (it is Resource.Success) {
                    cameraRepository.insertLocalCameras(it.data!!)
                }
            }
            return cameraRepository.getRemoteCameras()
        } else {
            return flow {
                emit(Resource.Success(data = data))
            }
        }
    }

}