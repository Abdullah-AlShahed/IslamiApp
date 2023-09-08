package com.example.islami.ui.home.tabs.quraan.chapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.ui.Constants
import com.example.islami.ui.home.tabs.quraan.chapterContent.VersesActivity

class QuranFragment : Fragment() {
    lateinit var bind: FragmentQuranBinding
    lateinit var quranAdapter: ChaptersAdapter
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
        quranAdapter = ChaptersAdapter(Constants.Chapters_Names.map {
            Chapter(it, Constants.Chapters_Names.indexOf(it) + 1)
        })
        quranAdapter.onItemClicked = ChaptersAdapter.onItemClickListner { position, sura ->
            startVersesActivity(position, sura)
        }
        quranRV.adapter = quranAdapter


    }

    override fun onStart() {
        super.onStart()
        val toolbarTitle: TextView = requireActivity().findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.the_quraan)
        bind.headerQuranIv.setOnClickListener {
            quranRV.smoothScrollToPosition(0)
        }
    }


    private fun startVersesActivity(position: Int, chapter: Chapter) {
        val intent = Intent(requireContext(), VersesActivity::class.java)
        intent.putExtra(Constants.EXTRA_CHAPTER_NAME, chapter.chapterName)
        intent.putExtra(Constants.EXTRA_CHAPTER_INDEX, position + 1)
        startActivity(intent)
    }


}