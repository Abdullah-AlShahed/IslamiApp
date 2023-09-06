package com.example.islami.ui.home.tabs.quraan.verses

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivityVersesBinding
import com.example.islami.ui.Constants

class VersesActivity : AppCompatActivity() {
    lateinit var bind: ActivityVersesBinding
    lateinit var adapter: VersesAdapter
    lateinit var versesRV: ActivityVersesBinding


    var suraName: String? = ""
    var suraIndex: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityVersesBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.suraDetailsBackBtn.setOnClickListener {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
        initParams()
        initViews()
        loadChapterFile()
    }

    private fun initViews() {
        bind.suraTitleTv.text = suraName
    }

    private fun initParams() {
        suraName = intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME)
        suraIndex = intent.getIntExtra(Constants.EXTRA_CHAPTER_INDEX, 0)
    }

    private fun loadChapterFile() {
        val fileName = "${suraIndex}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val chapterVerses = fileContent.trim().split("\n")
        bindVersesToRV(chapterVerses)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    private fun bindVersesToRV(chapterVerses: List<String>) {
        adapter = VersesAdapter(chapterVerses)
        bind.ayatRv.adapter = adapter
    }


}