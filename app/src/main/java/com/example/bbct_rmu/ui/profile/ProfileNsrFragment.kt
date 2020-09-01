package com.example.bbct_rmu.ui.profile

import android.app.Activity
import android.app.Presentation
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.bbct_rmu.R
import com.example.bbct_rmu.rest.Preferrences
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_profile_nsr.*
import kotlinx.android.synthetic.main.fragment_profile_nsr.view.*
import java.util.prefs.Preferences


class ProfileNsrFragment : Fragment() {
    lateinit var mPreferrences: Preferrences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile_nsr, container, false)

        initview(view)

        return view.rootView
    }

    private fun initview(view: View) {
        mPreferrences = Preferrences(context!!)
//        Toast.makeText(context, mPreferrences.GetIDItem(), Toast.LENGTH_SHORT).show()

        view.Pro_tvAge.text = mPreferrences.getAge()
        view.Pro_tvSex.text = mPreferrences.getSex()
        view.Pro_tvEmail.text = mPreferrences.getEmail()
        view.Pro_tvPhone.text = mPreferrences.getPhone()
        view.Pro_tvAdress.text = mPreferrences.getAdress()
    }

}