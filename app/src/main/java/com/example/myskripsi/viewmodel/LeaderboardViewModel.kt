package com.example.myskripsi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myskripsi.model.Peringkat

class LeaderboardViewModel : ViewModel() {

    // Wadah data yang bisa diubah (internal)
    private val _listPeringkat = MutableLiveData<List<Peringkat>>()

    // Wadah data yang hanya bisa dibaca (diekspos ke Fragment)
    val listPeringkat: LiveData<List<Peringkat>> = _listPeringkat

    init {
        loadDataPeringkat()
    }

    private fun loadDataPeringkat() {
        // Kita pindahkan data dummy peringkat ke sini
        val dummyData = listOf(
            Peringkat(4, "Siti Aminah", 2100),
            Peringkat(5, "Budi Santoso", 1950),
            Peringkat(6, "Ayu Lestari", 1820),
            Peringkat(7, "Reza Rahadian", 1700),
            Peringkat(8, "Nisa Sabyan", 1550),
            Peringkat(9, "Dito Ariotedjo", 1400),
            Peringkat(10, "Lina Marlina", 1250)
        )
        // Memasukkan data ke dalam wadah
        _listPeringkat.value = dummyData
    }
}