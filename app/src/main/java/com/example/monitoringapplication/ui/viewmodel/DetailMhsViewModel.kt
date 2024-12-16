package com.example.monitoringapplication.ui.viewmodel

import com.example.monitoringapplication.data.entity.Mahasiswa


// Memindahkan data dari entity ke UI
fun Mahasiswa.toDetailUiEvent(): MahasiswaEvent {
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        jenisKelamin = jenisKelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
    )
}