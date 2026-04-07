package com.example.myskripsi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels // Tambahan untuk memanggil ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myskripsi.adapter.MateriAdapter
import com.example.myskripsi.databinding.FragmentMateriBinding
import com.example.myskripsi.viewmodel.MateriViewModel

class MateriFragment : Fragment() {

    private var _binding: FragmentMateriBinding? = null
    private val binding get() = _binding!!

    // Memanggil ViewModel ke dalam Fragment
    private val viewModel: MateriViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMateriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fragment "memantau" isi listMateri dari ViewModel
        viewModel.listMateri.observe(viewLifecycleOwner) { dataMateri ->

            // Jika ada data masuk, kita langsung kirim ke Adapter
            val materiAdapter = MateriAdapter(dataMateri)

            binding.rvMateri.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = materiAdapter
                isNestedScrollingEnabled = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}