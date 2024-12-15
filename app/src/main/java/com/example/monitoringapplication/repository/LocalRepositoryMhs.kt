package com.example.monitoringapplication.repository

import com.example.monitoringapplication.data.dao.MahasiswaDao
import com.example.monitoringapplication.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

//implementasi dari RepositoryMhs
class LocalRepositoryMhs (
    private val mahasiswaDao: MahasiswaDao):
    RepositoryMhs {
        override suspend fun insertMhs(mahasiswa: Mahasiswa) {
            mahasiswaDao.insertMahasiswa(mahasiswa)
        }

    override fun getAllMahasiswa(): Flow<List<Mahasiswa>> {
        return mahasiswaDao.getAllMahasiswa()
    }

}



