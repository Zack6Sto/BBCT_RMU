package com.example.bbct_rmu

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.bbct_rmu.model.body.BodyUploadImage
import com.example.bbct_rmu.model.response.ResponseUploadImage
import com.example.bbct_rmu.ui.login.LoginActivity
import com.example.bbct_rmu.view.adapter.AdapterImageView
import com.tangxiaolv.telegramgallery.GalleryActivity
import com.tangxiaolv.telegramgallery.GalleryConfig
import kotlinx.android.synthetic.main.activity_insert_images.*

class InsertImagesActivity : AppCompatActivity() {
//    var PERMISSION_CODE = 1001
//    var PICK_IMAGE_MULTIPLE =1001
//    private var imageViewPagerAdapter: AdapterImageView? =null
//    var uploadImage = ArrayList<BodyUploadImage.Data>()
//    var photos: List<String> = ArrayList()
//
//    val mMainPersenter = MainPresenter()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_insert_images)
//
//        btnIMG_OK_Nsr.setOnClickListener {
//
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
//                    PackageManager.PERMISSION_DENIED
//                ) {
//                    //permission denied
//                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
//                    //show popup to request runtime permission
//                    requestPermissions(permissions, PERMISSION_CODE)
//                } else {
//                    //permission already granted
//                    pickImageFromGallery()
//                }
//            } else {
//                //system OS is < Marshmallow
//                pickImageFromGallery()
//            }
//
//        }
//
//        btnIMG_CC_Nsr.setOnClickListener {
//
//            mMainPersenter.UpLoadImage(
//                BodyUploadImage(uploadImage),
//
//                this::onSuccessSubscribe,
//                this::onErrorSubscribe
//            )
//        }
//
//
//    }
//
//    private fun pickImageFromGallery() {
//        val config = GalleryConfig.Build()
//            .limitPickPhoto(12)
//            .singlePhoto(false)
//            .hintOfPick("this is pick hint")
//            .filterMimeTypes(arrayOf("image/jpeg"))
//            .build()
//        GalleryActivity.openActivity(this@InsertImagesActivity, PICK_IMAGE_MULTIPLE, config)
//    }
//
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        when (requestCode) {
//            PERMISSION_CODE -> {
//                if (grantResults.size > 0 && grantResults[0] ==
//                    PackageManager.PERMISSION_GRANTED
//                ) {
//                    //permission from popup granted
//                    pickImageFromGallery()
//                } else {
//                    //permission from popup denied
//                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        try { // When an Image is picked
//            var encodedImage: String
//
//            photos = data!!.getSerializableExtra(GalleryActivity.PHOTOS) as List<String>
//
//            val viewPager = findViewById<ViewPager>(R.id.viewPager)
//
//            // for(i in photos){
//            imageViewPagerAdapter =
//                AdapterImageView(this@InsertImagesActivity, photos as ArrayList<String>)
//            //  }
//            viewPager.setAdapter(imageViewPagerAdapter)
//
//            val indicator = findViewById<CirclePageIndicator>(R.id.indicator).also {
//                it.setViewPager(viewPager)
//            }
//            val density = resources.displayMetrics.density
//            indicator.radius = 5 * density
//
//
//            //วนเอาที่รูปที่เลือกจาก gallery มา
//            for (i in photos) {
//
//                val file = File(i)
//
//                if (file.absolutePath != "") {
//
//                    //เอารูปมาแปลงเป็น bitmap
//                    val myBitmap = BitmapFactory.decodeFile(file.absolutePath)
//                    if (myBitmap != null) {
//                        val byteArrayOutputStream =
//                            ByteArrayOutputStream()
//                        myBitmap.compress(
//                            Bitmap.CompressFormat.JPEG,
//                            70,
//                            byteArrayOutputStream
//                        )
//
//                        //เแปลงรูปจาก bitmap เป็น base 64
//                        val byteArrayImage =
//                            byteArrayOutputStream.toByteArray()
//                        encodedImage = encodeToString(
//                            byteArrayImage,
//                            DEFAULT
//                        )
//
////                        Log.d("a9a20as8da", intent.extras?.getInt("n_id").toString())
//                        val bodyImage =
//                            BodyUploadImage.Data(
//                                intent.extras?.getInt("n_id").toString(),
//                                file.name, "data:image/jpeg;base64,$encodedImage")
//
//                        // val json: String = Utils().getGson()!!.toJson(bodyImage)
//                        //Log.d("ShowDataNoti2 : json ",json)
//
//                        uploadImage.add(bodyImage)
//                    }
//                }
//            }
//
//
//        } catch (e: Exception) {
//            //Log.d("ShowDataNoti2", e.message)
//            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
//                .show()
//        }
//        super.onActivityResult(requestCode, resultCode, data)
//    }

//    private fun onSuccessSubscribe(responseData: ResponseUploadImage) {
//        /*  val i = Intent(this, LoginActivity::class.java)
//          startActivity(i)*/
//        Toast.makeText(this, responseData.message, Toast.LENGTH_SHORT).show()
//
//        //ล้างรูปออก
//        viewPager.setAdapter(null)
//        photos = ArrayList()
//        uploadImage = ArrayList()
//
//
//
//        val i = Intent(this,LoginActivity::class.java)
//        startActivity(i)
//
//    }
//
//    private fun onErrorSubscribe(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//        Log.d("ShowDataNoti2", message)
//    }


}

