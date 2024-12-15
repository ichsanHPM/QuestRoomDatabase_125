package com.example.monitoringapplication.ui.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.monitoringapplication.data.entity.Mahasiswa
import com.example.monitoringapplication.repository.RepositoryMhs
import kotlinx.coroutines.launch

class MahasiswaViewModel(private val repositoryMhs: RepositoryMhs) : ViewModel() {

    var uiState by mutableStateOf(MhsUiState())

    fun updateState(mahasiswaEvent: MahasiswaEvent){
        uiState = uiState.copy(
            mahasiswaEvent = mahasiswaEvent,
        )
    }

    //validasi data dan input pengguna
    private fun validasiField(): Boolean{
        val event = uiState.mahasiswaEvent
        val errorState = FormErrorState(
            nim = if (event.nim.isNotEmpty()) null else "NIM tidak boleh kosong",
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            jenisKelamin = if (event.jenisKelamin.isNotEmpty()) null else "Jenis Kelamin tidak boleh kosong",
            alamat = if (event.alamat.isNotEmpty()) null else "Alamat tidak boleh kosong",
            kelas = if (event.kelas.isNotEmpty()) null else "Kelas tidak boleh kosong",
            angkatan = if (event.angkatan.isNotEmpty()) null else "Angkatan tidak boleh kosong",
        )
        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    //menyimpan data ke repository
    fun saveData(){
        val currentEvent = uiState.mahasiswaEvent

        //jika validasi benar maka akan memanggil repositoryMhs
        if (validasiField()){
            viewModelScope.launch {
                try{
                    repositoryMhs.insertMhs(currentEvent.toMahasiswaEntity())
                    uiState = uiState.copy(

                        //jika berhasil maka akan menampilkan snackbar
                        snackBarMessage = "Data berhasil disimpan",
                        mahasiswaEvent = MahasiswaEvent(),      //reset input form
                        isEntryValid = FormErrorState()      //reset error state
                    )
                }catch (e: Exception){
                    uiState = uiState.copy(
                        snackBarMessage = "Data gagal disimpan"
                    )
                }
            }
        }else{
            uiState = uiState.copy(
                snackBarMessage = "Input tidak valid.periksa kembali data anda"
            )
        }
    }

    //reset pesan snackbar setelah ditampilkan
    fun resetSnackBarMessage(){
        uiState = uiState.copy(snackBarMessage = null)

    }
}

//untuk merubah state/tampilan
//menghandle perubahan
data class MhsUiState(
    val mahasiswaEvent: MahasiswaEvent = MahasiswaEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),

    //snackbar = Pop Up
    val snackBarMessage: String? = null

)

//validasi error
data class FormErrorState(
    val nim: String? = null,
    val nama: String? = null,
    val jenisKelamin: String? = null,
    val alamat: String? = null,
    val kelas: String? = null,
    val angkatan: String? = null,
){
    fun isValid(): Boolean{
        return nim == null && nama == null && jenisKelamin == null &&
                alamat == null && kelas == null && angkatan == null

    }
}

//menyimpan input form ke dalam entity
//menyimpan ke model/entity
//digunakan saat memanggil repository
fun MahasiswaEvent.toMahasiswaEntity(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    jenisKelamin = jenisKelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan
)

//data class variable yang menyimpan data input form
//Event = TextField
data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val jenisKelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = ""
)