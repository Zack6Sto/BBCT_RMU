package com.example.bbct_rmu.member_nsr

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bbct_rmu.R
import com.example.bbct_rmu.member_nsr.fragments.ChatFragment
import com.example.bbct_rmu.member_nsr.fragments.HomeFragment
import com.example.bbct_rmu.member_nsr.fragments.ProfileFragment
import com.example.bbct_rmu.rest.Preferrences
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main_nsr.*

class MainNsrActivity : AppCompatActivity() {

    lateinit var mPreferrences: Preferrences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_nsr)
        val navView: BottomNavigationView = findViewById(R.id.bottom_nav)

        val navController = findNavController(R.id.nav_Nsr_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.mn_home,
            R.id.mn_chat,
            R.id.mn_profile
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



    }



}