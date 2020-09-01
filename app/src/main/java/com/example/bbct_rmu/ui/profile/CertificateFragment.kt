package com.example.bbct_rmu.ui.profile

import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.bbct_rmu.MainPresenter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataImg
import com.example.bbct_rmu.model.response.ResponseDataShowNsr
import com.example.bbct_rmu.model.response.ResponseImageData
import com.example.bbct_rmu.rest.Preferrences
import com.example.bbct_rmu.view.adapter.AdapterDataItem
import com.example.bbct_rmu.view.adapter.AdaterImageData
import com.example.bbct_rmu.view.adapter.ImageViewPagerCerticateAdapter
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.fragment_certificate.*


class CertificateFragment : Fragment() {
    val mPresenter= MainPresenter()
    lateinit var mPreferrences: Preferrences
    var mResponseData = ArrayList<ResponseDataImg>()
    lateinit var mAdaterImageData: AdaterImageData
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_certificate, container, false)
        setapiImage()
        return view.rootView
    }

    private fun setapiImage() {
        mPreferrences = Preferrences(context!!)
        mPresenter.MainSearchImgPersenterRx(mPreferrences.getIDItem().toInt(),this::Next,this::Error)
    }

    private fun Next(respone:List<ResponseDataImg>) {
        for (i in respone.indices){
           mResponseData.add(respone[i])
        }
        Log.d("ShowImage12345678",mResponseData.toString())
        mAdaterImageData = AdaterImageData(context!!,mResponseData)
        rcl_image.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdaterImageData
            mAdaterImageData.notifyDataSetChanged()
        }

    }

    private fun Error(message: String) {

    }

}
