package com.example.islami.ui.home.tabs.quraan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.ui.home.Constants

class QuranFragment : Fragment() {
    lateinit var bind: FragmentQuranBinding
    lateinit var quranAdapter: QuranSuraRecyclerAdapter
    lateinit var quranRV: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentQuranBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRV = bind.quranRv
        quranAdapter = QuranSuraRecyclerAdapter(Constants.arSuras.map {
            Sura(it, Constants.arSuras.indexOf(it) + 1)
        })
        quranAdapter.onItemClicked =
            QuranSuraRecyclerAdapter.onItemClickListner { position, sura ->
                val suraFragment = SuraFragment()
                val bundle = Bundle()
                bundle.putInt("suraNumber", Sura.)
                suraFragment.arguments = bundle
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(com.example.islami.R.id.main_container, suraFragment)
                    .addToBackStack(null).commit()
            }

        quranRV.adapter = quranAdapter
    }


}