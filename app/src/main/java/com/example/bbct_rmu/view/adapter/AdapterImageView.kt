package com.example.bbct_rmu.view.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.bbct_rmu.R

class AdapterImageView(private val ctx: Context, var mArrayUri: ArrayList<String>) : PagerAdapter() {

    var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return mArrayUri.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(ctx)
        val itemView: View = layoutInflater!!.inflate(R.layout.item_image_view, container, false)
        val imageView: ImageView = itemView.findViewById(R.id.imv_Gallery) as ImageView

        val myBitmap = BitmapFactory.decodeFile(mArrayUri[position])
        imageView.setImageBitmap(myBitmap)

        container.addView(itemView)

        return itemView
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }


}