package com.example.myskripsi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myskripsi.R

class LeaderboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menyambungkan fragment ini dengan desain fragment_leaderboard.xml
        return inflater.inflate(R.layout.fragment_leaderboard, container, false)
    }
}