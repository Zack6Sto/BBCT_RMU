package com.example.bbct_rmu.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bbct_rmu.MainPresenter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataNsr

class MainDeleteActivity : AppCompatActivity() {
    val mMainPresenter = MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_delete)

        setAPIDelete()
    }
    private fun setAPIDelete(){
        val id = intent.getIntExtra("id",0)
        mMainPresenter.DeleteNSRMainPersenterRx(id,
            this::onSuccessSubscrib,
            this::onErrorSubscrib)
    }

    private fun onErrorSubscrib(message: String) {
        Log.d("messageDelete",message)
    }

    private fun onSuccessSubscrib(responseDataNsr: ResponseDataNsr) {
        val I = Intent(this, MainActivity::class.java)
        startActivity(I)
    }

}