package com.example.islami.ui.home.tabs.quraan.verses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.databinding.VerseBinding

class VersesAdapter(val verses: List<String>) : Adapter<VersesAdapter.VersesViewHolder>() {

    class VersesViewHolder(val binding: VerseBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        var binding = VerseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VersesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return verses.size
    }

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {
        holder.binding.ayahTv.text = verses[position]
    }


}