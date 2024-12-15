package com.example.monitoringapplication.repository

import com.example.monitoringapplication.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

//interface semacam panduan
interface RepositoryMhs {

    //suspend digunakan untuk operasi yang berat seperti create, delete, insert
    suspend fun insertMhs(mahasiswa: Mahasiswa)
    fun getAllMahasiswa(): Flow<List<Mahasiswa>>
}