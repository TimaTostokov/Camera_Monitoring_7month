package com.example.my.camera_monitoring_7month.presentation.base

import androidx.lifecycle.ViewModel
import com.example.my.camera_monitoring_7month.domain.utils.Resource
import com.example.my.camera_monitoring_7month.presentation.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseViewModel : ViewModel() {

    protected suspend fun <T> collectData(useCase: suspend () -> Flow<Resource<T>>): UiState<T> {
        var value: UiState<T> = UiState.Loading()
        useCase().flowOn(Dispatchers.IO).collect { resource ->
            value = when (resource) {
                is Resource.Loading -> UiState.Loading()
                is Resource.Success -> {
                    val data = resource.data
                    if (data != null) {
                        UiState.Success(data = data)
                    } else {
                        UiState.Empty()
                    }
                }

                is Resource.Error -> UiState.Error(message = resource.message ?: "ERROR")
            }
        }
        return value
    }

}