package com.example.myskripsi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels // Tambahan untuk memanggil ViewModel
import com.example.myskripsi.databinding.FragmentProfilBinding
import com.example.myskripsi.viewmodel.ProfilViewModel

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    // Memanggil ViewModel
    private val viewModel: ProfilViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Memantau Username
        viewModel.username.observe(viewLifecycleOwner) { nama ->
            binding.tvUsername.text = nama
        }

        // 2. Memantau XP dan menghitung Progress Bar
        viewModel.xpSekarang.observe(viewLifecycleOwner) { xpSaatIni ->
            val targetXp = viewModel.xpTarget.value ?: 1000 // Ambil target, default 1000

            // Set teks "650 / 1000 XP"
            binding.tvXp.text = "$xpSaatIni / $targetXp XP"

            // Set nilai batas maksimal progress bar
            binding.progressXp.max = targetXp

            // Animasi sederhana ngisi progress bar
            binding.progressXp.setProgress(xpSaatIni, true)
        }

        // 3. Aksi klik pada menu (Tetap dipertahankan)
        binding.menuRiwayat.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka Riwayat Belajar...", Toast.LENGTH_SHORT).show()
        }
        binding.menuNotifikasi.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka Notifikasi...", Toast.LENGTH_SHORT).show()
        }
        binding.menuSettings.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka Pengaturan...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}