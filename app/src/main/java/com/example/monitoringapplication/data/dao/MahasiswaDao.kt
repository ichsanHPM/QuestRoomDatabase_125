package com.example.monitoringapplication.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.monitoringapplication.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao
interface MahasiswaDao {

    //mengambil semua data mahasiswa yang tersimpan di database yang diurutkan berdasarkan nama secara ascending (ASC)
    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa() : Flow<List<Mahasiswa>>

    //mengambil data mahasiswa berdasarkan NIM
    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    fun getMahasiswa(nim: String) : Flow<Mahasiswa>

    //menghapus data mahasiswa tertentu dari database
    @Delete
    suspend fun updateMahasiswa(mahasiswa: Mahasiswa)

    //memperbaharui informasi mahasiswa yang sudah ada di database
    @Update
    suspend fun updateMahasiswa(mahasiswa: Mahasiswa)

    @Insert
    suspend fun insertMahasiswa(
        mahasiswa: Mahasiswa
    )
}