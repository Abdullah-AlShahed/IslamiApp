package com.example.islami.ui.home.tabs.quraan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivitySuraDetailsBinding

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var bind: ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(bind.root)

    }
}