package com.example.myskripsi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myskripsi.adapter.LeaderboardAdapter
import com.example.myskripsi.databinding.FragmentLeaderboardBinding
import com.example.myskripsi.model.Peringkat

class LeaderboardFragment : Fragment() {

    private var _binding: FragmentLeaderboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Membuat Data Dummy (Mulai dari peringkat 4)
        val listPeringkat = listOf(
            Peringkat(4, "Siti Aminah", 2100),
            Peringkat(5, "Budi Santoso", 1950),
            Peringkat(6, "Ayu Lestari", 1820),
            Peringkat(7, "Reza Rahadian", 1700),
            Peringkat(8, "Nisa Sabyan", 1550),
            Peringkat(9, "Dito Ariotedjo", 1400),
            Peringkat(10, "Lina Marlina", 1250)
        )

        // 2. Memasang Adapter ke RecyclerView
        val leaderboardAdapter = LeaderboardAdapter(listPeringkat)
        binding.rvLeaderboard.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = leaderboardAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}