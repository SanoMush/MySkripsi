package com.example.myskripsi.model

data class Materi(
    val id: String,
    val judulBab: String,
    val deskripsi: String,
    val status: StatusMateri // Kita buat enum khusus untuk status
)

enum class StatusMateri {
    SELESAI, AKTIF, TERKUNCI
}