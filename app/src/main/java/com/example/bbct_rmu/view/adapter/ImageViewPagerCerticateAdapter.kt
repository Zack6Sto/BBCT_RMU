package com.example.bbct_rmu.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.rest.BasUrl_IMG_Certicate
import com.squareup.picasso.Picasso

class ImageViewPagerCerticateAdapter(private val ctx: Context, var mArrayUri: ArrayList<String>) :
    PagerAdapter() {
    var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return mArrayUri.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(ctx)
        val itemView: View = layoutInflater!!.inflate(R.layout.item_viewpager_certicate, container, false)
        val imageView: ImageView = itemView.findViewById(R.id.imv_Certicate) as ImageView

        Picasso.get().load(BasUrl_IMG_Certicate+mArrayUri[position]).into(imageView)
        Log.d("Show",mArrayUri.get(position))

        container.addView(itemView)

        return itemView
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

}