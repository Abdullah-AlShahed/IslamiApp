package com.example.islami.ui.home.tabs.quraan.chapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.databinding.ChapterBinding

class ChaptersAdapter(var chapterList: List<Chapter>) :
    Adapter<ChaptersAdapter.QuranSuraViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranSuraViewHolder {
        val bind =
            ChapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuranSuraViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return chapterList.size
    }

    override fun onBindViewHolder(holder: QuranSuraViewHolder, position: Int) {
        holder.bind.surahNameTv.text = chapterList[position].chapterName
        holder.bind.surahNumberTv.text = chapterList[position].chapterNumber.toString()
        if (onItemClicked != null) {
            holder.bind.root.setOnClickListener {
                onItemClicked?.onItemClick(position, chapterList[position])
            }
        }
    }

    var onItemClicked: onItemClickListner? = null

    fun interface onItemClickListner {
        fun onItemClick(position: Int, chapter: Chapter)
    }

    class QuranSuraViewHolder(val bind: ChapterBinding) : RecyclerView.ViewHolder(bind.root)
}