package com.example.bbct_rmu.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataReview
import com.example.bbct_rmu.rest.BasUrl_IMG_PR
import com.squareup.picasso.Picasso
import java.util.ArrayList

class AdapterReview (
    private var context: Context,
    private var mDataReview: ArrayList<ResponseDataReview>,
    private var mImage:Int,
    private var mInvork: (String,String,String,String) ->(Unit))

    : RecyclerView.Adapter<AdapterReview.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_review,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = mDataReview.size

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.namereview.text = mDataReview[position].name_review
        holder.Data.text = mDataReview[position].r_text
        holder.time.setText(mDataReview[position].r_time)

        //Log.d("imageComment",mDataPost[position].img)
        Picasso.get()
            .load(BasUrl_IMG_PR +mDataReview.get(position).img_review)
            .into(holder.image)
    }




    class ViewHolder(itemsView: View) : RecyclerView.ViewHolder(itemsView) {

        val time  = itemsView.findViewById<TextView>(R.id.tv_timeRV)
        val image: ImageView = itemsView.findViewById(R.id.imv_pro_RV)
        val Data: TextView = itemsView.findViewById(R.id.tv_textRV)
        val namereview: TextView = itemsView.findViewById(R.id.tv_nameRV)
    }
}
