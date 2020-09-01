package com.example.bbct_rmu.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.bbct_rmu.view.main.MainActivity
import com.example.bbct_rmu.R
import com.example.bbct_rmu.member_nsr.MainNsrActivity
import com.example.bbct_rmu.model.response.*
import com.example.bbct_rmu.rest.Preferrences
import com.example.bbct_rmu.ui.register.RegisterActivity
import com.example.bbct_rmu.view.main.MainEditActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.dialog_message_show.view.*

class LoginActivity : AppCompatActivity() {
    var mLoginPersenter = LoginPresenter()
    var mPreferrences= Preferrences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initview()
        register()
        Login()
    }

    private fun initview() {
        if (checkIslogin(mPreferrences.getUsername())&&checkIslogin(mPreferrences.getStatus())){
            if (mPreferrences.getStatus() == "ผู้ปกครอง"){
                finish()
                startActivity(
                    Intent(this, MainActivity::class.java)
                )
            }
            else if (mPreferrences.getStatus() == "พี่เลี้ยงเด็ก"){
                finish()
                startActivity(
                    Intent(this,MainNsrActivity::class.java)
                )
            }
        }
    }


    private fun register(){
        signup_button.setOnClickListener {
            val mIntent = Intent(this, RegisterActivity::class.java)
            startActivity(mIntent)
        }
    }

    private fun Login() {
        signin_button.setOnClickListener {
            var un = login_Email.text.toString()
            var pw = login_Password.text.toString()
            val inserBtn =rdg_Status.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(inserBtn)
            val Status = radioButton.text.toString()
            if (un!=""&&pw!="") {
                if (Status =="พี่เลี้ยงเด็ก") {
                    setapi(un, pw, Status)
                 }
                else if (Status=="ผู้ปกครอง"){
                    setapiPr(un,pw,Status)
                }
            }
            else if (un!=""&&pw==""){
                ShowDialogMessage("กรุณากรอกรหัสผ่าน")
            }
            else if (un==""&&pw!=""){
                ShowDialogMessage("กรุณากรอกชื่อผู้ใช้")
            }else{
                ShowDialogMessage("กรุณากรอกชื่อผู้ใช้ เเละ รหัสผ่าน")
            }
        }
    }



    private fun ShowDialogMessage(Message: String){
        val View = layoutInflater.inflate(R.layout.dialog_message_show,null)
        View.Message_dialog_Show.setText(Message)
        View.btn_OK_show.setText("ปิด")
        val dialog = AlertDialog.Builder(this@LoginActivity).apply {
            setTitle("คำเตือน!!")
            setIcon(R.drawable.alert)
            setView(View)
        }
        val dialogButton = dialog.show()
        View.btn_OK_show.setOnClickListener {
            dialogButton.dismiss()
        }
    }


    //เช็ค Login ผู้ปกครอง
    private fun setapiPr(un:String, pw:String, status:String){
        mLoginPersenter.LoginPRPersenterRx(un,pw,status,this::LoginPRNext,this::LoginPrError)
    }

    private fun LoginPrError(message:String){
        Toast.makeText(applicationContext,"รหัสไม่ถูกต้อง", Toast.LENGTH_LONG).show()
    }

    private fun LoginPRNext(responseLogin: List<ResponseLoginPRItem>){
        mPreferrences.saveID(responseLogin[0].u_id.toString())
        mPreferrences.saveUsername(responseLogin[0].u_username)
        mPreferrences.saveStatus(responseLogin[0].u_status)
        mPreferrences.saveName(responseLogin[0].u_fname+responseLogin[0].u_lname)
        mLoginPersenter.MainSearchImgPrPersenterRx(responseLogin[0].u_id,this::SearchNext,this::SearchError)
    }

    private fun SearchNext(response: List<ResponseDataImgPr>) {
        mPreferrences.saveIDImg(response[0].img_u_id.toString())
        mPreferrences.saveImg(response[0].u_img)
        startActivity(
            Intent(applicationContext,MainActivity::class.java)
        )
        finish()
    }

    private fun SearchError(message: String) {

    }

    //เช็ค Login พี่เลี้ยงเด็ก
    private fun setapi(un:String, pw:String, status:String){
        mLoginPersenter.LoginNsrPersenter(un,pw,status,
            this::onSuccessSubscrib,
            this::onErrorSubscrib)
    }

    private fun onSuccessSubscrib(responseLogin: List<ResponseLoginNSRItem>) {
        mPreferrences.saveID(responseLogin[0].n_id.toString())
        mPreferrences.saveUsername(responseLogin[0].n_username)
        mPreferrences.saveStatus(responseLogin[0].n_status)
        mPreferrences.saveName(responseLogin[0].n_fname+responseLogin[0].n_lname)
        mLoginPersenter.MainSearchImgNsrPersenterRx(responseLogin[0].n_id,this::SearchNsrNext,this::SearchNsrError)

    }

    private fun SearchNsrError(message: String) {

    }

    private fun SearchNsrNext(response: List<ResponseDataImgNsr>) {
       mPreferrences.saveIDImg(response[0].id_img_pro.toString())
        mPreferrences.saveImg(response[0].img_pro)
        startActivity(
            Intent(applicationContext,MainNsrActivity::class.java)
        )
        finish()
    }

    private fun onErrorSubscrib(Message: String) {
        Toast.makeText(applicationContext,"รหัสไม่ถูกต้อง", Toast.LENGTH_LONG).show()
    }


    fun  checkIslogin(username: String): Boolean{
        return username.isNotEmpty()
    }

}