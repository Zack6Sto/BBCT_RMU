package com.example.bbct_rmu.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bbct_rmu.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        tati()
    }

    private fun tati(){
        RGT_Parent.setOnClickListener {
            val mIntent = Intent(this, RegisterParentActivity::class.java)
            startActivity(mIntent)
        }

        RGT_Nursery.setOnClickListener {
            val mIntent = Intent(this, RegisterNurseryActivity::class.java)
            startActivity(mIntent)
        }
    }

}