package com.example.islami.ui.home.tabs.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentHadethBinding

class HadethFragment : Fragment() {
    lateinit var bind: FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentHadethBinding.inflate(inflater, container, false)
        return bind.root
    }

}