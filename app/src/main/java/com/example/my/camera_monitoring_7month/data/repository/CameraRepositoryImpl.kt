package com.example.my.camera_monitoring_7month.data.repository

import com.example.my.camera_monitoring_7month.data.dtos.toDataDto
import com.example.my.camera_monitoring_7month.data.dtos.toDomainModel
import com.example.my.camera_monitoring_7month.data.local.db.CameraDao
import com.example.my.camera_monitoring_7month.data.remoute.HouseApiService
import com.example.my.camera_monitoring_7month.data.utils.GetResource
import com.example.my.camera_monitoring_7month.domain.models.CameraModel
import com.example.my.camera_monitoring_7month.domain.repository.CameraRepository
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(
    private val dao: CameraDao,
    private val houseApiService: HouseApiService,
) : CameraRepository, GetResource() {
    override suspend fun getRemoteCameras() = getResult {
        houseApiService.getCamera().body()!!.data.cameras.toDomainModel()
    }

    override fun getLocalCameras(): List<CameraModel> {
        return dao.getAllCameras().toDomainModel()
    }

    override fun insertCamera(cameraModel: CameraModel) {
        dao.insertCamera(cameraModel.toDataDto())
    }

    override fun insertLocalCameras(cameraModels: List<CameraModel>) {
        dao.insertAllCameras(cameraModels.toDataDto())
    }

    override fun updateCamera(cameraModel: CameraModel) {
        dao.updateCamera(cameraModel.toDataDto())
    }

    override fun updateLocalCameras(cameraModels: List<CameraModel>) {
        dao.updateAllCameras(cameraModels.toDataDto())
    }

    override fun deleteCamera(cameraModel: CameraModel) {
        dao.deleteCamera(cameraModel.toDataDto())
    }

}