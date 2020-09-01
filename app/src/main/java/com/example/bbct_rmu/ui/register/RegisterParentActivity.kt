package com.example.bbct_rmu.ui.register

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import com.example.bbct_rmu.MainPresenter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataPr
import com.example.bbct_rmu.ui.login.LoginActivity
import com.squareup.picasso.Picasso
import com.tangxiaolv.telegramgallery.GalleryActivity
import com.tangxiaolv.telegramgallery.GalleryConfig
import kotlinx.android.synthetic.main.activity_register_nursery.*
import kotlinx.android.synthetic.main.activity_register_parent.*
import kotlinx.android.synthetic.main.activity_register_parent.RGT_Next_Nursery
import kotlinx.android.synthetic.main.popup.*
import java.io.File

class RegisterParentActivity : AppCompatActivity() {
    private lateinit var imageName : File
    private var PICK_IMAGE = 999
    private lateinit var Image: ImageView
    val mMainPersenter = MainPresenter()
    lateinit var myDialog :Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_parent)
        Image = findViewById(R.id.profile_PR_RGT)
        satapi()
        init()
    }


    private fun satapi(){
        btn_OK_Pr.setOnClickListener {
            mMainPersenter.InsertPRMainPersenter(
                RGT_Code_Parent.text.toString(),
                RGT_User_Parent.text.toString(),
                RGT_Pass_Parent.text.toString(),
                RGT_FName_Parent.text.toString(),
                RGT_LName_Parent.text.toString(),
                RGT_Age_Parent.text.toString(),
                RGT_Phone_Parent.text.toString(),
                RGT_Email_Parent.text.toString(),
                "ผู้ปกครอง",
                "รออนุมัติ",
                this::onSuccessSubscrib,
                this::onErrorSubscrib)
        }
        fab_ProImg_PR.setOnClickListener {
            val i = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(i,PICK_IMAGE)
        }
    }


    private fun onSuccessSubscrib(responseData: ResponseDataPr) {
//        myDialog = Dialog(this)
//        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        myDialog.setContentView(R.layout.popup)
//        myDialog.show()
        Log.d("registerImageMessage",imageName.name)
        mMainPersenter.UploadProfileUserPR(responseData.u_id.toString(),imageName){
            if (it){
                val mIntent = Intent(this,RegisterActivity::class.java)
                startActivity(mIntent)
                Toast.makeText(applicationContext, "ลงทะเบียน1รูปผ่าน", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(applicationContext, "ผิดพลาด", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun onErrorSubscrib(message: String) {
        Log.d("messageInsert",message)

    }

    private fun init(){
        btn_CC_Pr.setOnClickListener {
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            Toast.makeText(applicationContext, "ยกเลิกการลงทะเบียน", Toast.LENGTH_LONG).show()
        }


        RGT_Next_Nursery.setOnClickListener {
            startActivity(
                Intent(this,RegisterNurseryActivity::class.java)
              )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            try {
                val pickedImage: Uri = data?.data!!
                val filePath = arrayOf(MediaStore.Images.Media.DATA)
                val cursor: Cursor =
                    this.contentResolver.query(pickedImage, filePath, null, null, null)!!
//                    activity!!.contentResolver.query(pickedImage, filePath, null, null, null)!!
                cursor.moveToFirst()
                val imagePath: String = cursor.getString(cursor.getColumnIndex(filePath[0]))
                val options = BitmapFactory.Options()
                options.inPreferredConfig = Bitmap.Config.ARGB_8888
                val bitmap = BitmapFactory.decodeFile(imagePath, options)

                Log.d("As5da1sda", File(imagePath).absolutePath)
                imageName = File(imagePath)
                Picasso.get().load(imageName).into(profile_PR_RGT)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}