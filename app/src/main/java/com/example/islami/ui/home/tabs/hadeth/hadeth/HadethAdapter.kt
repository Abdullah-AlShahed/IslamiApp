package com.example.islami.ui.home.tabs.hadeth.hadeth

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.HadethBinding

class HadethAdapter(private var hadethList: List<Hadeth>?) :
    RecyclerView.Adapter<HadethAdapter.HadethViewHolder>() {
    @SuppressLint("NotifyDataSetChanged")
    fun bindHadethList(hadethList: List<Hadeth>) {
        this.hadethList = hadethList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        val bind =
            HadethBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HadethViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return hadethList?.size ?: 0
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        holder.bind.hadethNameTv.text = hadethList!![position].title
        if (onItemClicked != null) {
            holder.bind.root.setOnClickListener {
                onItemClicked?.onItemClick(position, hadethList!![position])
            }
        }
    }

    var onItemClicked: onItemClickListner? = null

    fun interface onItemClickListner {
        fun onItemClick(position: Int, hadeth: Hadeth)
    }

    class HadethViewHolder(val bind: HadethBinding) : RecyclerView.ViewHolder(bind.root)
}



