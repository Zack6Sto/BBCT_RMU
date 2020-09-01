package com.example.bbct_rmu.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataImg
import com.example.bbct_rmu.model.response.ResponseImageData
import com.example.bbct_rmu.rest.BasUrl_IMG_Certicate
import com.squareup.picasso.Picasso

class AdaterImageData(var ct :Context,private var mDataImage :ArrayList<ResponseDataImg>):RecyclerView.Adapter<ViewHolderImageData>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderImageData {
        return ViewHolderImageData(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_viewpager_certicate,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderImageData, position: Int) {
        Picasso.get().load(BasUrl_IMG_Certicate+mDataImage[position].img_normal).into(holder.image)
    }

    override fun getItemCount() = mDataImage.size
}

class ViewHolderImageData(item :View):RecyclerView.ViewHolder(item){
    val image = item.findViewById<ImageView>(R.id.imv_Certicate)
}