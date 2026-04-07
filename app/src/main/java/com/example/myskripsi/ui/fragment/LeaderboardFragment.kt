package com.example.myskripsi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels // Tambahan untuk memanggil ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myskripsi.adapter.LeaderboardAdapter
import com.example.myskripsi.databinding.FragmentLeaderboardBinding
import com.example.myskripsi.viewmodel.LeaderboardViewModel

class LeaderboardFragment : Fragment() {

    private var _binding: FragmentLeaderboardBinding? = null
    private val binding get() = _binding!!

    // Memanggil ViewModel ke dalam Fragment
    private val viewModel: LeaderboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fragment "memantau" isi listPeringkat dari ViewModel
        viewModel.listPeringkat.observe(viewLifecycleOwner) { dataPeringkat ->

            // Masukkan data baru ke adapter
            val leaderboardAdapter = LeaderboardAdapter(dataPeringkat)

            binding.rvLeaderboard.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = leaderboardAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}