package com.example.my.camera_monitoring_7month.presentation.ui.fragments.doors

import androidx.lifecycle.viewModelScope
import com.example.my.camera_monitoring_7month.data.local.db.DoorDao
import com.example.my.camera_monitoring_7month.domain.models.DoorModel
import com.example.my.camera_monitoring_7month.domain.usecases.doors.DeleteDoorUseCase
import com.example.my.camera_monitoring_7month.domain.usecases.doors.GetAllDoorsUseCase
import com.example.my.camera_monitoring_7month.domain.usecases.doors.InsertDoorUseCase
import com.example.my.camera_monitoring_7month.domain.usecases.doors.RefreshDoorsUseCase
import com.example.my.camera_monitoring_7month.domain.usecases.doors.UpdateDoorUseCase
import com.example.my.camera_monitoring_7month.domain.utils.Resource
import com.example.my.camera_monitoring_7month.presentation.base.BaseViewModel
import com.example.my.camera_monitoring_7month.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val getAllDoorsUseCase: GetAllDoorsUseCase,
    private val refreshDoorsUseCase: RefreshDoorsUseCase,
    private val insertDoorUseCase: InsertDoorUseCase,
    private val updateDoorUseCase: UpdateDoorUseCase,
    private val deleteDoorUseCase: DeleteDoorUseCase
) : BaseViewModel() {

    private val _doorsList = MutableStateFlow<UiState<List<DoorModel>>>(UiState.Loading())
    val doorsList: StateFlow<UiState<List<DoorModel>>> = _doorsList

    fun getAllDoors() = doRequest {
        getAllDoorsUseCase()
    }

    fun refreshDoors() = doRequest {
        refreshDoorsUseCase()
    }

    private fun doRequest(useCase: suspend () -> Flow<Resource<List<DoorModel>>>) {
        viewModelScope.launch(Dispatchers.IO) {
            _doorsList.value = collectData { useCase() }
        }
    }

    fun onDoorsSwiped(doors: Int) = viewModelScope.launch {
        DoorDao.delete(doors)
    }

}