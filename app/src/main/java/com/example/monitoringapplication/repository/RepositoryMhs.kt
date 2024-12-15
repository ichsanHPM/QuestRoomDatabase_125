package com.example.monitoringapplication.repository

import com.example.monitoringapplication.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

//interface semacam panduan
interface RepositoryMhs {

    //suspend digunakan untuk operasi yang berat seperti create, delete, insert
    suspend fun insertMhs(mahasiswa: Mahasiswa)

    //untuk menghapus data mahasiswa
    suspend fun deleteMhs(mahasiswa: Mahasiswa)

    //untuk memperbaharui data mahasiswa
    suspend fun updateMhs(mahasiswa: Mahasiswa)

    //metode ini memanggil fungsi get all mahasiswa dari MahasiswaDao untuk mendapatkan semua data
    fun getAllMahasiswa(): Flow<List<Mahasiswa>>

    //metode ini memanggil fungsi getMahasiswa dari MahasiswaDao untuk mengambil data mahasiswa berdasarkan NIM
    fun getMhs(nim: String): Flow<Mahasiswa>


}