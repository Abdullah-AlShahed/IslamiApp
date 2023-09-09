package com.example.islami.ui.home.tabs.hadeth.hadethContent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islami.R
import com.example.islami.databinding.ActivityHadethContentBinding
import com.example.islami.ui.Constants
import com.example.islami.ui.home.tabs.hadeth.hadeth.Hadeth

class HadethContentActivity : AppCompatActivity() {
    lateinit var bind: ActivityHadethContentBinding
    var hadeth: Hadeth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_content)
        bind = ActivityHadethContentBinding.inflate(layoutInflater)
        setContentView(bind.root)
        initViews()
        initParams()
        bindHadeth()

    }

    private fun initViews() {
        bind.hadethDetailsBackBtn.setOnClickListener {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }

    private fun bindHadeth() {
        bind.hadethTitleTv.text = hadeth?.title
        bind.hadethTv.text = hadeth?.body

    }


    private fun initParams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getSerializableExtra(Constants.EXTRA_HADETH, Hadeth::class.java)
        } else {
            hadeth = intent.getSerializableExtra(Constants.EXTRA_HADETH) as Hadeth
        }
    }
}