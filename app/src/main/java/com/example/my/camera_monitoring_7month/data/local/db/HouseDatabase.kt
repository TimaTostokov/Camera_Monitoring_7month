package com.example.my.camera_monitoring_7month.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.my.camera_monitoring_7month.data.dtos.CameraDto
import com.example.my.camera_monitoring_7month.data.dtos.DoorDto

@Database(entities = [CameraDto::class, DoorDto::class], version = 2, exportSchema = true)
abstract class HouseDatabase : RoomDatabase() {
    abstract fun getCameraDao(): CameraDao
    abstract fun getDoorDao(): DoorDao
}