package com.example.islami.ui.home.tabs.hadeth.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.databinding.FragmentHadethBinding

class HadethFragment : Fragment() {
    lateinit var bind: FragmentHadethBinding
    lateinit var adapter: HadethAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentHadethBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        adapter = HadethAdapter(null)
        bind.hadethRv.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        val toolbarTitle: TextView = requireActivity().findViewById(R.id.toolbar_title)
        toolbarTitle.text = getString(R.string.the_hadeth)
        bind.headerHadethIv.setOnClickListener {
            bind.hadethRv.smoothScrollToPosition(0)
        }
        loadHadethFile()
        bindHadethList()
    }

    private fun bindHadethList() {
        adapter.bindHadethList(hadethList)
    }

    val hadethList = mutableListOf<Hadeth>()
    private fun loadHadethFile() {
        val fileContent =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val hadethList = fileContent.trim().split("#").forEach { element ->
            val hadethListLines = element.trim().split("\n")
            val hadethtitle = hadethListLines[0]
            val hadethBody = hadethListLines.joinToString { "\n" }
            val hadeth = Hadeth(hadethtitle, hadethBody)
            hadethList.add(hadeth)
        }

//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }


}