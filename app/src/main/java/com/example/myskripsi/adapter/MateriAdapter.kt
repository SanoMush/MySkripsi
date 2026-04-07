package com.example.myskripsi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myskripsi.R
import com.example.myskripsi.databinding.ItemMateriBinding
import com.example.myskripsi.model.Materi
import com.example.myskripsi.model.StatusMateri

// Adapter ini akan menerima list (daftar) materi
class MateriAdapter(private val listMateri: List<Materi>) :
    RecyclerView.Adapter<MateriAdapter.MateriViewHolder>() {

    // Menggunakan ViewBinding untuk menyambungkan ID dari item_materi.xml
    inner class MateriViewHolder(val binding: ItemMateriBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MateriViewHolder {
        val binding = ItemMateriBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MateriViewHolder(binding)
    }

    override fun getItemCount(): Int = listMateri.size

    override fun onBindViewHolder(holder: MateriViewHolder, position: Int) {
        val materi = listMateri[position]

        with(holder.binding) {
            tvJudulBab.text = materi.judulBab
            tvDeskripsi.text = materi.deskripsi

            // 1. Reset tampilan ke mode 'sembunyi' dulu agar tidak bocor dari item lain
            ivStatusIcon.visibility = View.GONE
            tvBabNumber.visibility = View.GONE
            chipAktif.visibility = View.GONE
            root.alpha = 1.0f
            root.strokeWidth = 2 // 1dp dalam pixel kasar
            root.strokeColor = ContextCompat.getColor(root.context, R.color.border_subtle)
            flIconBg.setBackgroundResource(R.drawable.bg_icon_gray)
            ivAction.setImageResource(R.drawable.ic_chevron_right)

            // 2. Tampilkan sesuai status materinya
            when (materi.status) {
                StatusMateri.SELESAI -> {
                    ivStatusIcon.visibility = View.VISIBLE
                    flIconBg.setBackgroundResource(R.drawable.bg_icon_green)
                }
                StatusMateri.AKTIF -> {
                    tvBabNumber.visibility = View.VISIBLE
                    tvBabNumber.text = "0${position + 1}"
                    tvBabNumber.setTextColor(ContextCompat.getColor(root.context, R.color.purple_primary))

                    chipAktif.visibility = View.VISIBLE
                    flIconBg.setBackgroundResource(R.drawable.bg_icon_purple)

                    // Buat border card jadi tebal dan ungu
                    root.strokeWidth = 5
                    root.strokeColor = ContextCompat.getColor(root.context, R.color.purple_primary)
                }
                StatusMateri.TERKUNCI -> {
                    tvBabNumber.visibility = View.VISIBLE
                    tvBabNumber.text = "0${position + 1}"
                    tvBabNumber.setTextColor(ContextCompat.getColor(root.context, R.color.text_tertiary))

                    root.alpha = 0.55f // Bikin agak transparan
                    ivAction.setImageResource(R.drawable.ic_lock) // Ubah panah jadi gembok
                }
            }
        }
    }
}