package com.example.bbct_rmu.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataShowNsr
import com.example.bbct_rmu.rest.BasUrl_IMG_NSR
import com.squareup.picasso.Picasso

class   AdapterDataItem (
    private var context: Context,
    private var mData: ArrayList<ResponseDataShowNsr>,
    private var mImage:Int,
    private var mInvork: (String,String,String,String,String,String,String,String,String) ->(Unit))

    : RecyclerView.Adapter<AdapterDataItem.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_data,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = mData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fname.text = mData[position].n_fname
        holder.lname.text = mData[position].n_lname
        Picasso.get()
            .load(BasUrl_IMG_NSR + mData.get(position).img)
            .into(holder.imagePro)
//        holder.image.setImageResource(mImage)

        holder.itemView.setOnClickListener {
            mInvork.invoke(mData[position].n_id.toString(),mData[position].n_fname,mData[position].n_lname,mData[position].n_sex
                ,mData[position].n_age,mData[position].n_phone,mData[position].n_address,mData[position].n_email,mData[position].img)
        }

    }

    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {

        val imagePro: ImageView = itemsView.findViewById(R.id.Im_ShowPro)
        val fname: TextView = itemsView.findViewById(R.id.Tv_ShowFName)
        val lname: TextView = itemsView.findViewById(R.id.Tv_ShowLName)

    }
}