package com.example.myskripsi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
// Import class binding untuk fragment profil
import com.example.myskripsi.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {

    // Deklarasi binding khusus untuk Fragment
    private var _binding: FragmentProfilBinding? = null
    // Properti ini hanya boleh dipanggil antara onCreateView dan onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inisialisasi binding
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- CONTOH PENGGUNAAN BINDING DI SINI --- //

        // Mengubah teks (ID tv_username di XML otomatis menjadi tvUsername di Kotlin)
        binding.tvUsername.text = "Siswa Teladan"

        // Memberikan aksi klik pada card menu riwayat
        binding.menuRiwayat.setOnClickListener {
            // Toast ini akan memunculkan pesan kecil di bawah layar
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
        // Wajib dikosongkan agar memori aplikasi tidak bocor (memory leak)
        _binding = null
    }
}