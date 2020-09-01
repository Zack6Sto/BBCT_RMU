package com.example.bbct_rmu.ui.profile

import android.os.Build.ID
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.bbct_rmu.R
import com.example.bbct_rmu.rest.BasUrl_IMG_NSR
import com.example.bbct_rmu.view.adapter.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val n_fname:String? = intent.getStringExtra("n_fname")
        val n_lname:String? = intent.getStringExtra("n_lname")
        val img:String? = intent.getStringExtra("img")

        Pro_tvFName.text = n_fname
        Pro_tvLName.text = n_lname


        Picasso.get()
            .load(BasUrl_IMG_NSR + img)
            .into(Pro_ImgP)


        var viewPager = findViewById<ViewPager2>(R.id.view_Pager)
        viewPager.adapter = PagerAdapter(supportFragmentManager,lifecycle)
        var TadLayout = findViewById<TabLayout>(R.id.tab_Layout)
        var data = arrayListOf<String>("ประวัติ","ใบรับรอง","รีวิว")
        TabLayoutMediator(TadLayout,viewPager){
            tab, position ->  tab.text =data.get(position)
        }.attach()
    }




}