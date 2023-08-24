package com.example.islami.ui.home.tabs.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {
    lateinit var bind: FragmentRadioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentRadioBinding.inflate(inflater, container, false)
        return bind.root
    }

}