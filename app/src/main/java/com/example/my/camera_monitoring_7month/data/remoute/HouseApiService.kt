package com.example.my.camera_monitoring_7month.data.remoute

import com.example.my.camera_monitoring_7month.data.dtos.CamerasDto
import com.example.my.camera_monitoring_7month.data.dtos.DoorsDto
import retrofit2.Response
import retrofit2.http.GET

interface HouseApiService {

    @GET("cameras/")
    suspend fun getCamera(): Response<CamerasDto>

    @GET("doors/")
    suspend fun getDoor(): Response<DoorsDto>
}