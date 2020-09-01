package com.example.bbct_rmu.ui.profile

import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bbct_rmu.MainPresenter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataComment
import com.example.bbct_rmu.model.response.ResponseDataReview
import com.example.bbct_rmu.rest.Preferrences
import com.example.bbct_rmu.view.adapter.AdapterComment
import com.example.bbct_rmu.view.adapter.AdapterReview
import kotlinx.android.synthetic.main.activity_main_post_comment.*
import kotlinx.android.synthetic.main.fragment_review.*
import kotlinx.android.synthetic.main.fragment_review.view.*
import java.util.*


class ReviewFragment : Fragment() {
    val mImage:Int =(R.drawable.logo_png)
    val mMainPresenter= MainPresenter()
    val mResponseDataReview = ArrayList<ResponseDataReview>()
    lateinit var mAdapterReview: AdapterReview
    lateinit var mPreferrences: Preferrences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_review, container, false)


        view.btn_SEND_Review.setOnClickListener {
            setAPIReview(view)
        }

        return view.rootView
    }

    private fun setAPIReview(view: View) {
        val calendar  = Calendar.getInstance()
        val y  = calendar.get(Calendar.YEAR)
        val m  = calendar.get(Calendar.MONDAY)
        val d  = calendar.get(Calendar.DATE)
        val h  = calendar.get(Calendar.HOUR)
        val mm  = calendar.get(Calendar.MINUTE)
        val time =  "${d}/${m}/${y} - ${h}:${mm}"
        var message =EDT_Review.text.toString()
        mPreferrences = Preferrences(context!!)
        mMainPresenter.InsertReviewPersenter(mPreferrences.getIDItem(),mPreferrences.getID(),mPreferrences.getUsername(),mPreferrences.getImagefile(),message,time,this::ReviewtNext,this::ReviewError)
    }

    private fun ReviewError(message: String) {

    }

    private fun ReviewtNext(response: ResponseDataReview) {
        EDT_Review.text.clear()
        mResponseDataReview.clear()
        mAdapterReview.notifyDataSetChanged()
        satapi()
    }

    private fun satapi() {
        mMainPresenter.MainPersenterReview(mPreferrences.getIDItem().toInt(),
        this::onSuccessSubscrib,
        this::onErrorSubscrib)
    }

    private fun onErrorSubscrib(message: String) {

    }

    fun onSuccessSubscrib(response: List<ResponseDataReview>) {
        for (i in response.indices){
            mResponseDataReview.add(response[i])
        }

        mAdapterReview = AdapterReview(
            this.requireContext()
            ,mResponseDataReview
            , mImage
        ) { r_text,r_time,name_review,img_review -> }


        Review_RecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapterReview
            mAdapterReview.notifyDataSetChanged()
        }
    }


}