package com.example.bbct_rmu.ui.register

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.bbct_rmu.InsertImagesActivity
import com.example.bbct_rmu.MainPresenter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataNsr
import com.example.bbct_rmu.model.response.ResponseNSR
import com.example.bbct_rmu.ui.login.LoginActivity
import com.example.bbct_rmu.view.adapter.AdapterImageView
import com.squareup.picasso.Picasso
import com.tangxiaolv.telegramgallery.GalleryActivity
import com.tangxiaolv.telegramgallery.GalleryConfig
import kotlinx.android.synthetic.main.activity_insert_images.*
import kotlinx.android.synthetic.main.activity_register_nursery.*
import java.io.File

class RegisterNurseryActivity : AppCompatActivity() {

    private lateinit var imageName :File
    private var PICK_IMAGE = 999
    val mMainPersenter = MainPresenter()
    var PERMISSION_CODE = 1001
    var PICK_IMAGE_MULTIPLE = 1001
    lateinit var Group: RadioGroup
    private var imageViewPagerAdapter: AdapterImageView? = null
    var photos: List<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_nursery)
        satapi()
        init()
    }

    private fun satapi(){
        btn_OK_Nsr.setOnClickListener {
            Group = findViewById(R.id.RDG_Sex_Nursery)
            var rdo =Group.checkedRadioButtonId
            var Sex = findViewById<RadioButton>(rdo)


            mMainPersenter.InsertNurseryPersenterRx(
                RGT_Code_Nursery.text.toString(),
                RGT_User_Nursery.text.toString(),
                RGT_Pass_Nursery.text.toString(),
                RGT_FName_Nursery.text.toString(),
                RGT_LName_Nursery.text.toString(),
                Sex.text.toString(),
                RGT_Age_Nursery.text.toString(),
                RGT_Phone_Nursery.text.toString(),
                RGT_Address_Nursery.text.toString(),
                RGT_Email_Nursery.text.toString(),
                "พี่เลี้ยงเด็ก",
                "รออนุมัติ",
                this::onSuccessSubscrib,
                this::onErrorSubscrib)

        }

        fab_ProImg.setOnClickListener {
            val i = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(i,PICK_IMAGE)
        }


    }



private fun onSuccessSubscrib(responseData: ResponseNSR) {
//
//    Log.d("registerImageMessage",imageName.name)
    mMainPersenter.UploadImageUserPresenterRX(responseData.n_id.toString(),imageName){
        if (it){
            val mIntent = Intent(this, RegisterActivity::class.java)
    startActivity(mIntent)
        Toast.makeText(applicationContext, "ลงทะเบียน1รูปผ่าน", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext, "ผิดพลาด", Toast.LENGTH_LONG).show()
        }
        mMainPersenter.UploadImageUserSPresenterRX(responseData.n_id.toString(),photos)
        {if (it){
            Toast.makeText(applicationContext, "ลงทะเบียนหลายรูปผ่าน", Toast.LENGTH_LONG).show()
        }
            else{
            Toast.makeText(applicationContext, "ผิดพลาด", Toast.LENGTH_LONG).show()
        }

        }
    }
    }

    private fun onErrorSubscrib(message: String) {
        Log.d("messageInsert",message)

    }

    private fun init(){
        btn_CC_Nsr.setOnClickListener {
            val mIntent = Intent(this, RegisterActivity::class.java)
            startActivity(mIntent)
            Toast.makeText(applicationContext, "ยกเลิกการลงทะเบียน", Toast.LENGTH_LONG).show()
        }

        floatingActionButton.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE)
                } else {
                    //permission already granted
                    pickImageFromGallery()
                }
            } else {
                //system OS is < Marshmallow
                pickImageFromGallery()
            }
        }

        RGT_Next_Parent.setOnClickListener {
            startActivity(
                Intent(this,RegisterParentActivity::class.java)
            )
        }
    }

    private fun pickImageFromGallery() {
        val config = GalleryConfig.Build()
            .limitPickPhoto(12)
            .singlePhoto(false)
            .hintOfPick("this is pick hint")
            .filterMimeTypes(arrayOf("image/*")) // ตัวกรองไฟล์รูป
            .build()
        GalleryActivity.openActivity(this@RegisterNurseryActivity, PICK_IMAGE_MULTIPLE, config)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==PICK_IMAGE && resultCode==Activity.RESULT_OK){
            try {
                val pickedImage : Uri = data?.data!!
                val filePath = arrayOf(MediaStore.Images.Media.DATA)
                val cursor: Cursor =this.contentResolver.query(pickedImage,filePath,null,null,null)!!
//                    activity!!.contentResolver.query(pickedImage, filePath, null, null, null)!!
                cursor.moveToFirst()
                val imagePath: String = cursor.getString(cursor.getColumnIndex(filePath[0]))
                val options = BitmapFactory.Options()
                options.inPreferredConfig = Bitmap.Config.ARGB_8888
                val bitmap = BitmapFactory.decodeFile(imagePath, options)

                Log.d("As5da1sda", File(imagePath).absolutePath )
                imageName = File(imagePath)
                Picasso.get().load(imageName).into(profile_NSR_RGT)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        try { // When an Image is picked
            var encodedImage: String

            photos = data!!.getSerializableExtra(GalleryActivity.PHOTOS) as List<String>

            // for(i in photos){
            imageViewPagerAdapter = AdapterImageView(this@RegisterNurseryActivity, photos as ArrayList<String>)
            //  }
            viewPager_Img.setAdapter(imageViewPagerAdapter)
        } catch (e: Exception) {
            //Log.d("ShowDataNoti2", e.message)
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery()
                } else {
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}