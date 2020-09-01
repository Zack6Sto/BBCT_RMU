package com.example.bbct_rmu.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bbct_rmu.ui.profile.CertificateFragment
import com.example.bbct_rmu.ui.profile.ProfileNsrFragment
import com.example.bbct_rmu.ui.profile.ReviewFragment

class PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    var fragments:ArrayList<Fragment> = arrayListOf(
        ProfileNsrFragment(), CertificateFragment(), ReviewFragment()
    )
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}