package com.example.myskripsi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfilViewModel : ViewModel() {

    // Menyimpan Nama Pengguna
    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    // Menyimpan XP saat ini
    private val _xpSekarang = MutableLiveData<Int>()
    val xpSekarang: LiveData<Int> = _xpSekarang

    // Menyimpan Target XP untuk naik level
    private val _xpTarget = MutableLiveData<Int>()
    val xpTarget: LiveData<Int> = _xpTarget

    init {
        loadDataProfil()
    }

    private fun loadDataProfil() {
        // Data dummy untuk profil
        _username.value = "Sano Mush"
        _xpSekarang.value = 800 // Ubah angka ini untuk ngetes progress bar-nya
        _xpTarget.value = 1000
    }
}