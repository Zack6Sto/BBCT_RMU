package com.example.bbct_rmu.ui.post

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bbct_rmu.MainPresenter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataComment
import com.example.bbct_rmu.rest.BasUrl_IMG_PR
import com.example.bbct_rmu.rest.Preferrences
import com.example.bbct_rmu.view.adapter.AdapterComment
import com.example.bbct_rmu.view.main.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_post_comment.*
import java.util.*

class PostCommentActivity : AppCompatActivity() {
    val mImage:Int =(R.drawable.logo_png)
    var mMainPresenter= MainPresenter()
    var mResponseDataComment = ArrayList<ResponseDataComment>()
    private var  ID = ""
    lateinit var mAdapterComment: AdapterComment
    lateinit var mPreferrences: Preferrences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_post_comment)

        val username: String? =intent.getStringExtra("username")
        val p_text: String? = intent.getStringExtra("p_text")
        val p_time: String? = intent.getStringExtra("p_time")
        val p_id = intent.getStringExtra("p_id")
        val img:String? = intent.getStringExtra("img")

        Picasso.get()
            .load(BasUrl_IMG_PR+img)
            .into(imvProPic_comment)

        ID = p_id.toString()
        tv_PostStatusCM.text = p_text
        tv_name.text = username
        tv_time.text = p_time

        btn_SEND_Comment.setOnClickListener {
            setAPIComment()
        }

        satapi()
    }

    private fun setAPIComment() {
            val calendar  = Calendar.getInstance()
            val y  = calendar.get(Calendar.YEAR)
            val m  = calendar.get(Calendar.MONDAY)
            val d  = calendar.get(Calendar.DATE)
            val h  = calendar.get(Calendar.HOUR)
            val mm  = calendar.get(Calendar.MINUTE)
            val time =  "${d}/${m}/${y} - ${h}:${mm}"
            var message =EDT_Comment.text.toString()
            mPreferrences = Preferrences(this)
            mMainPresenter.InsertCommentPersenter(ID,mPreferrences.getID(),mPreferrences.getUsername(),mPreferrences.getImagefile(),message,time,this::commentNext,this::commentError)
    }

    private fun commentNext(response:ResponseDataComment) {
        EDT_Comment.text.clear()
        mResponseDataComment.clear()
        mAdapterComment.notifyDataSetChanged()
        satapi()
    }

    private fun commentError(message : String) {
    }

    private fun satapi(){
    mMainPresenter.MainPersenterCommentRx(ID.toInt(),
        this::onSuccessSubscrib,
        this::onErrorSubscrib
    )
}


    fun onSuccessSubscrib(response: List<ResponseDataComment>) {
        for (i in response.indices){
            mResponseDataComment.add(response[i])
    }

            mAdapterComment = AdapterComment(
                this,mResponseDataComment
                , mImage
            ) { p_text,p_time,username,img -> }


    recyclerViewComment.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = mAdapterComment
        mAdapterComment.notifyDataSetChanged()
    }
}

fun onErrorSubscrib(Message: String) {
}



}

