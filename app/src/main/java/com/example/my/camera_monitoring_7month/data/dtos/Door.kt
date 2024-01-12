package com.example.my.camera_monitoring_7month.data.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.my.camera_monitoring_7month.data.utils.Constants.EMPTY_STRING
import com.example.my.camera_monitoring_7month.domain.models.DoorModel
import com.google.gson.annotations.SerializedName

data class DoorsDto(
    val data: List<DoorDto>,
    val success: Boolean
)

@Entity(tableName = "door_table")
data class DoorDto(
    @PrimaryKey
    val id: Long,
    val favorites: Boolean,
    val name: String,
    val room: String = EMPTY_STRING,
    @SerializedName("snapshot")
    val image: String = EMPTY_STRING
)

fun DoorDto.toDomainModel() =
    DoorModel(id, favorites, name, room ?: EMPTY_STRING, image ?: EMPTY_STRING)

fun DoorModel.toDataDto() = DoorDto(id, favorites, name, room, image)

fun List<DoorDto>.toDomainModel() = this.map { it.toDomainModel() }

fun List<DoorModel>.toDataDto() = this.map { it.toDataDto() }
