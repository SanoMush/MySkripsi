package com.example.myskripsi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myskripsi.model.Materi
import com.example.myskripsi.model.StatusMateri

class MateriViewModel : ViewModel() {

    // MutableLiveData: wadah data yang isinya bisa kita ubah-ubah dari dalam ViewModel
    private val _listMateri = MutableLiveData<List<Materi>>()

    // LiveData: wadah data yang HANYA BISA DIBACA oleh Fragment (agar aman dan tidak diubah sembarangan)
    val listMateri: LiveData<List<Materi>> = _listMateri

    // init dipanggil pertama kali saat ViewModel dibuat
    init {
        loadDataMateri()
    }

    private fun loadDataMateri() {
        // Data dummy kita pindahkan ke sini
        val dummyData = listOf(
            Materi("1", "Bab 1: Sistem Komputer", "Hardware, software & brainware", StatusMateri.SELESAI),
            Materi("2", "Bab 2: Jaringan Komputer", "LAN, WAN, topologi jaringan", StatusMateri.SELESAI),
            Materi("3", "Bab 3: Algoritma & Pemrograman", "Logika, pseudocode & flowchart", StatusMateri.AKTIF),
            Materi("4", "Bab 4: Basis Data", "SQL, relasi tabel & normalisasi", StatusMateri.TERKUNCI),
            Materi("5", "Bab 5: Kecerdasan Buatan", "Machine learning & neural network", StatusMateri.TERKUNCI)
        )
        // Memasukkan data ke dalam wadah
        _listMateri.value = dummyData
    }
}