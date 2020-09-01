package com.example.bbct_rmu.view.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bbct_rmu.R
import com.example.bbct_rmu.rest.Preferrences
import com.example.bbct_rmu.ui.login.LoginActivity
import com.example.bbct_rmu.ui.post.PostActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mPreferrences: Preferrences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_dashboard,
            R.id.navigation_notifications
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



    }



//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.main_menu,menu)
//
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item?.itemId){
//            R.id.app_bar_logout ->{
//                mPreferrences = Preferrences(this)
//                mPreferrences.clear()
//                val i = Intent(this, LoginActivity::class.java)
//                startActivity(i)
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }










}