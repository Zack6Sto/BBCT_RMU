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
import com.example.bbct_rmu.model.response.ResponseDataComment
import com.example.bbct_rmu.rest.BasUrl_IMG_NSR
import com.example.bbct_rmu.rest.BasUrl_IMG_PR
import com.squareup.picasso.Picasso
import java.util.ArrayList

class AdapterComment (
    private var context: Context,
    private var mDataPost: ArrayList<ResponseDataComment>,
    private var mImage:Int,
    private var mInvork: (String,String,String,String) ->(Unit))

    : RecyclerView.Adapter<AdapterComment.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_comment,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = mDataPost.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.namecoment.text = mDataPost[position].name_cm
        holder.Data.text = mDataPost[position].cm_text
        holder.time.setText(mDataPost[position].cm_time)
        //Log.d("imageComment",mDataPost[position].img)
        Picasso.get()
                .load(BasUrl_IMG_PR+mDataPost.get(position).img_cm)
                .into(holder.image)
    }

    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {

        val time  = itemsView.findViewById<TextView>(R.id.TV_TimeCM)
        val image: ImageView = itemsView.findViewById(R.id.imvProPic)
        val Data: TextView = itemsView.findViewById(R.id.TV_DataComment)
        val namecoment: TextView = itemsView.findViewById(R.id.TV_NameCM)
    }
}