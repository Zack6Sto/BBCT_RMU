package com.example.bbct_rmu.member_nsr.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bbct_rmu.MainPresenter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataPost
import com.example.bbct_rmu.rest.Preferrences
import com.example.bbct_rmu.ui.post.PostCommentActivity
import com.example.bbct_rmu.view.adapter.AdapterPost
import kotlinx.android.synthetic.main.fragment_home2.*

class HomeFragment : Fragment() {

    val mImage:Int =(R.drawable.logo_png)
    var mMainPresenter= MainPresenter()
    var mResponseDataPost = ArrayList<ResponseDataPost>()
    lateinit var mPreferrences: Preferrences
    lateinit var mAdapterPost: AdapterPost

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home2, container, false)

        satapi()
        return root.rootView

    }

    private fun satapi(){

        mMainPresenter.MainPersenterPostRx(
            this::onSuccessSubscrib,
            this::onErrorSubscrib
        )
    }


    fun onSuccessSubscrib(response: List<ResponseDataPost>) {
        for (i in response.indices){
            mResponseDataPost.add(response[i])
        }
        mAdapterPost = AdapterPost(
            this.requireContext(),
            mResponseDataPost,
            mImage
        ) { p_id,p_text,p_time,username,img ->
            val i = Intent(context, PostCommentActivity::class.java)
            i.putExtra("p_id", p_id)
            i.putExtra("p_text", p_text)
            i.putExtra("p_time", p_time)
            i.putExtra("username", username)
            startActivity(i)
        }


        Nsr_recyclerViewHome.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapterPost
            mAdapterPost.notifyDataSetChanged()
        }
    }

    fun onErrorSubscrib(Message: String) {
    }


}
