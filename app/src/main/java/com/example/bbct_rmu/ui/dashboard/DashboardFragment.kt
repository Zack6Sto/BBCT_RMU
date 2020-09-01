package com.example.bbct_rmu.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bbct_rmu.MainPresenter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.member_nsr.fragments.ProfileFragment
import com.example.bbct_rmu.model.response.ResponseDataNsr
import com.example.bbct_rmu.model.response.ResponseDataShowNsr
import com.example.bbct_rmu.rest.Preferrences
import com.example.bbct_rmu.ui.profile.ProfileActivity
import com.example.bbct_rmu.ui.profile.ProfileNsrFragment
import com.example.bbct_rmu.view.adapter.AdapterDataItem
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment() {

    val mImage:Int =(R.drawable.logo_png)
    var mMainPresenter= MainPresenter()
    var mResponseData = ArrayList<ResponseDataShowNsr>()
    lateinit var mPreferrences: Preferrences
    lateinit var mAdapterDataItem: AdapterDataItem



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        satapi()
        return root.rootView

    }

    private fun satapi(){

        mMainPresenter.MainPersenterRx(
            this::onSuccessSubscrib,
            this::onErrorSubscrib
        )
    }

    fun onSuccessSubscrib(response: List<ResponseDataShowNsr>) {
        for (i in response.indices){
            mResponseData.add(response[i])
        }

        mAdapterDataItem = AdapterDataItem(
            this.requireContext(),
            mResponseData,
            mImage
        ) { n_id,n_fname, n_lname, n_sex, n_age, n_phone, n_address, n_email,img ->
            val i = Intent(context, ProfileActivity::class.java)
            i.putExtra("n_id", n_id)
            i.putExtra("n_fname", n_fname)
            i.putExtra("n_lname", n_lname)
            i.putExtra("img", img)
            startActivity(i)
            mPreferrences = Preferrences(context!!)
//            mPreferrences.saveAge(n_age)
//            mPreferrences.saveSex(n_sex)
//            mPreferrences.saveEmail(n_email)
//            mPreferrences.savePhone(n_phone)
//            mPreferrences.saveAdress(n_address)
            mPreferrences.saveIDItem(n_id)
        }


        recyclerView_Nsr.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapterDataItem
            mAdapterDataItem.notifyDataSetChanged()
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    fun onErrorSubscrib(Message: String) {
    }


}