package com.example.islami.ui.home.tabs.quraan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.databinding.ItemSuraNumberAndNameBinding

class QuranSuraRecyclerAdapter(var surasLst: List<Sura>) :
    Adapter<QuranSuraRecyclerAdapter.QuranSuraViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranSuraViewHolder {
        val bind =
            ItemSuraNumberAndNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuranSuraViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return surasLst.size
    }

    override fun onBindViewHolder(holder: QuranSuraViewHolder, position: Int) {
        holder.bind.surahNameTv.text = surasLst[position].suraName
        holder.bind.surahNumberTv.text = surasLst[position].suraNumber.toString()
        if (onItemClicked != null) {
            holder.bind.root.setOnClickListener {
                onItemClicked?.onItemClick(position, surasLst[position])
            }

        }
    }

    var onItemClicked: onItemClickListner? = null

    fun interface onItemClickListner {
        fun onItemClick(position: Int, sura: Sura)
    }

    class QuranSuraViewHolder(val bind: ItemSuraNumberAndNameBinding) :
        RecyclerView.ViewHolder(bind.root) {
    }

}