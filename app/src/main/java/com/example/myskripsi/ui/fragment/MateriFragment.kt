package com.example.myskripsi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myskripsi.adapter.MateriAdapter
import com.example.myskripsi.databinding.FragmentMateriBinding
import com.example.myskripsi.model.Materi
import com.example.myskripsi.model.StatusMateri

class MateriFragment : Fragment() {

    private var _binding: FragmentMateriBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMateriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Membuat Data Dummy
        val listMateri = listOf(
            Materi("1", "Bab 1: Sistem Komputer", "Hardware, software & brainware", StatusMateri.SELESAI),
            Materi("2", "Bab 2: Jaringan Komputer", "LAN, WAN, topologi jaringan", StatusMateri.SELESAI),
            Materi("3", "Bab 3: Algoritma & Pemrograman", "Logika, pseudocode & flowchart", StatusMateri.AKTIF),
            Materi("4", "Bab 4: Basis Data", "SQL, relasi tabel & normalisasi", StatusMateri.TERKUNCI),
            Materi("5", "Bab 5: Kecerdasan Buatan", "Machine learning & neural network", StatusMateri.TERKUNCI)
        )

        // 2. Memasang Adapter ke RecyclerView
        val materiAdapter = MateriAdapter(listMateri)
        binding.rvMateri.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = materiAdapter
            // Ini mematikan scroll bawaan recyclerview karena kita pakai NestedScrollView di XML
            isNestedScrollingEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}