package com.example.islami.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.ui.home.tabs.hadeth.HadethFragment
import com.example.islami.ui.home.tabs.quraan.QuranFragment
import com.example.islami.ui.home.tabs.radio.RadioFragment
import com.example.islami.ui.home.tabs.sebha.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bind: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bind.root)
        //to set click listener on bottom navigation bar
        onBottomNavBarTabsClicked()
        //to show quraan fragment when open app
        bind.homeContent.bottomNavigation.selectedItemId = R.id.navigation_quraan
    }

    private fun onBottomNavBarTabsClicked() {
        bind.homeContent.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_quraan -> {
                    showClickedFragmentContent(QuranFragment())
                }

                R.id.navigation_hadeth -> {
                    showClickedFragmentContent(HadethFragment())
                }

                R.id.navigation_sebha -> {
                    showClickedFragmentContent(SebhaFragment())
                }

                R.id.navigation_radio -> {
                    showClickedFragmentContent(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun showClickedFragmentContent(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }


}