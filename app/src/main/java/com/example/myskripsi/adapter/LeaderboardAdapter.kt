package com.example.myskripsi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myskripsi.databinding.ItemLeaderboardBinding
import com.example.myskripsi.model.Peringkat

class LeaderboardAdapter(private val listPeringkat: List<Peringkat>) :
    RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>() {

    // Menyambungkan dengan file item_leaderboard.xml
    inner class LeaderboardViewHolder(val binding: ItemLeaderboardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewHolder {
        val binding = ItemLeaderboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LeaderboardViewHolder(binding)
    }

    override fun getItemCount(): Int = listPeringkat.size

    override fun onBindViewHolder(holder: LeaderboardViewHolder, position: Int) {
        val peringkat = listPeringkat[position]

        with(holder.binding) {
            // Memasukkan data ke tampilan
            tvPosisi.text = peringkat.posisi.toString()
            tvNama.text = peringkat.nama
            // Format teks XP agar ada komanya (misal: 1,200 XP)
            tvXp.text = "%,d XP".format(peringkat.xp)
        }
    }
}