package com.example.islami.ui.home.tabs.quraan.chapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.ui.Constants
import com.example.islami.ui.home.tabs.quraan.verses.VersesActivity

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


    private fun startVersesActivity(position: Int, chapter: Chapter) {
        val intent = Intent(requireContext(), VersesActivity::class.java)
        intent.putExtra(Constants.EXTRA_CHAPTER_NAME, chapter.chapterName)
        intent.putExtra(Constants.EXTRA_CHAPTER_INDEX, position + 1)
        startActivity(intent)
    }


}