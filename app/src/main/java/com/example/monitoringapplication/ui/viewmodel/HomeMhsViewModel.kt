package com.example.monitoringapplication.ui.viewmodel

import com.example.monitoringapplication.data.entity.Mahasiswa

data class HomeUiState (
    val listMhs: List<Mahasiswa> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)