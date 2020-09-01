package com.example.bbct_rmu.member_nsr.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bbct_rmu.R
import com.example.bbct_rmu.rest.BasUrl_IMG_NSR
import com.example.bbct_rmu.rest.Preferrences
import com.example.bbct_rmu.ui.login.LoginActivity
import com.example.bbct_rmu.ui.post.PostActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.fragment_home2.view.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {
    lateinit var mPreferrences: Preferrences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        setLogout(root)
        initview(root)

        return root.rootView

    }


    private fun initview(view: View) {
        mPreferrences = Preferrences(this.requireContext())
        view.user_id.setText(mPreferrences.getUsername())
        view.nameNSRPro.setText(mPreferrences.getName())
        Picasso.get()
            .load(BasUrl_IMG_NSR+mPreferrences.getImagefile())
            .into(view.img_Profile_Nsr)

    }

    private fun setLogout(view: View) {
        view.Btn_Logout.setOnClickListener {
            mPreferrences= Preferrences(context!!)
            mPreferrences.clear()
            startActivity(
                Intent(context, LoginActivity::class.java)
            )
        }
    }

}