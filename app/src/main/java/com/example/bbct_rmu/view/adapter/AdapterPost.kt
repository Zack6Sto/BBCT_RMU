package com.example.bbct_rmu.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataPost
import com.example.bbct_rmu.rest.BasUrl_IMG_PR
import com.example.bbct_rmu.rest.Preferrences
import com.squareup.picasso.Picasso
import java.util.ArrayList

class AdapterPost (
    private var context: Context,
    private var mDataPost:ArrayList<ResponseDataPost>,
    private var mImage:Int,
    private var mInvork: (String,String,String,String,String) ->(Unit))



    : RecyclerView.Adapter<AdapterPost.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_feed,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = mDataPost.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.namefeed.setText(mDataPost[position].username)
        holder.name.text = mDataPost[position].p_text
        holder.time.setText(mDataPost[position].p_time)
        if (mDataPost[position].img!=null) {
            Picasso.get()
                .load(BasUrl_IMG_PR + mDataPost.get(position).img)
                .into(holder.imageProPost)
        }
        else{
            Picasso.get()
                .load("http://192.168.1.11:4000/uploads_profile_user/Screenshot_2020-08-21-12-02-57.png")
                .into(holder.imageProPost)
        }
//        Glide.with(context).load(mImage).into(holder.image)

        holder.itemView.setOnClickListener {
            mInvork.invoke(mDataPost[position].p_id,mDataPost[position].p_text,mDataPost[position].p_time,mDataPost[position].username,mDataPost[position].img)

        }

    }

    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {

        val time  = itemsView.findViewById<TextView>(R.id.tv_time)
        val imageProPost: ImageView = itemsView.findViewById(R.id.imv_pro_post)
        val name: TextView = itemsView.findViewById(R.id.tv_PostStatus)
        val namefeed: TextView = itemsView.findViewById(R.id.TV_NameFeed)
    }
}