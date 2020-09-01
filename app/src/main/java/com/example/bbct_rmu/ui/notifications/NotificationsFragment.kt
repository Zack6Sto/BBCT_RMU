package com.example.bbct_rmu.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bbct_rmu.R
import com.example.bbct_rmu.rest.BasUrl_IMG_PR
import com.example.bbct_rmu.rest.Preferrences
import com.example.bbct_rmu.ui.login.LoginActivity
import com.example.bbct_rmu.ui.report.ReportActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class NotificationsFragment : Fragment() {
    lateinit var mPreferrences: Preferrences
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        setapi(root)
        return root
    }

    private fun setapi(view: View) {
        view.Btn_Pr_Report.setOnClickListener {
            startActivity(
                Intent(context,ReportActivity::class.java)
            )
        }

        mPreferrences = Preferrences(this.requireContext())
        view.userPr_id.setText(mPreferrences.getUsername())
        view.namePrPro.setText(mPreferrences.getName())
        Picasso.get()
            .load(BasUrl_IMG_PR +mPreferrences.getImagefile())
            .into(view.img_Profile)

        view.Btn_Pr_Logout.setOnClickListener {
            mPreferrences= Preferrences(context!!)
            mPreferrences.clear()
            startActivity(
                Intent(context, LoginActivity::class.java)
            )
        }
    }
}