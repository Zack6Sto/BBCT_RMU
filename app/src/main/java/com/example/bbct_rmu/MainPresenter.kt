package com.example.bbct_rmu

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import com.example.bbct_rmu.model.body.*
import com.example.bbct_rmu.model.response.*
import com.example.bbct_rmu.rest.DataModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import jp.wasabeef.picasso.transformations.internal.Utils
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.concurrent.TimeUnit

class MainPresenter {
    var mDisposable: Disposable? = null

    //Get NSR
    fun MainPersenterRx(
        dataResponse : (List<ResponseDataShowNsr>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doGetNSR()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataShowNsr>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataShowNsr>) {
                    Log.d("messageNsr", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageNsr",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }


    fun MainDataNSRItemPersenterRx(
        id:Int,
        dataResponse : (List<ResponseDataShowNsr>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.dodataNSRItem(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataShowNsr>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataShowNsr>) {
                    Log.d("messageNsr", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageNsr",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }





    //GET POST
    fun MainPersenterPostRx(
        dataResponse : (List<ResponseDataPost>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doGetPost()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataPost>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataPost>) {
                    Log.d("messagePost", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messagePost",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    //GET COMMENT
    fun MainPersenterCommentRx(
        id:Int,
        dataResponse : (List<ResponseDataComment>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doGetComment(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataComment>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataComment>) {
                    Log.d("messageComment", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageComment",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    //GET REVIEW
    fun MainPersenterReview(
        id:Int,
        dataResponse : (List<ResponseDataReview>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doGetReview(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataReview>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataReview>) {
                    Log.d("messageReview", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageReview",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }


    //    Get IMG Certicate
    fun MainSearchImgPersenterRx(
        id:Int,
        dataResponse : (List<ResponseDataImg>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.dosearchImg(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataImg>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataImg>) {
                    Log.d("ShowImage12345678", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("ShowImage12345678",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }



    //RX InsertPR
    fun InsertPRMainPersenter(
        u_code: String,
        u_username: String,
        u_password: String,
        u_fname: String,
        u_lname: String,
        u_age: String,
        u_phone: String,
        u_email: String,
        u_status: String,
        u_add:String,
        dataResponse : (ResponseDataPr) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doInsertPR(
            BodyInsert(u_code, u_username, u_password,
            u_fname, u_lname, u_age, u_phone, u_email,u_status,u_add) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataPr>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataPr) {
                    Log.d("messageInsert", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageInsert",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    fun InsertNurseryPersenterRx(
        n_code: String,
        n_username: String,
        n_password: String,
        n_fname: String,
        n_lname: String,
        n_sex: String,
        n_age: String,
        n_phone: String,
        n_address: String,
        n_email: String,
        n_status: String,
        n_add:String,
        dataResponse : (ResponseNSR) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doInsertNSR(
            BodyInsertNSR(n_code, n_username, n_password,
            n_fname, n_lname,n_sex, n_age, n_phone,n_address,n_email,n_status,n_add) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseNSR>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseNSR) {
                    Log.d("messageInsertNursery", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageInsertNursery",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }


    //RX InsertPost
    fun InsertPostPersenter(
        u_id: String,
        p_text:String,
        p_time:String,
        username:String,

        dataResponse : (ResponseDataPost) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doInsertPost(BodyInsertPost(u_id,p_text,p_time,username) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataPost>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataPost) {
                    Log.d("messageInsert", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageInsert",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    //RX InsertComment
    fun InsertCommentPersenter(
        p_id:String,
        u_id:String,
        name_cm:String,
        img_cm:String,
        cm_text:String,
        cm_time:String,

        dataResponse : (ResponseDataComment) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doInsertComment(BodyInsertComment(p_id,u_id,name_cm,img_cm,cm_text,cm_time) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataComment>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataComment) {
                    Log.d("messageInsert", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageInsert",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    //RX InsertReview
    fun InsertReviewPersenter(
        n_id:String,
        u_id:String,
        name_review:String,
        img_review:String,
        r_text:String,
        r_time:String,

        dataResponse : (ResponseDataReview) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doInsertReview(BodyInsertReview(n_id,u_id,name_review,img_review,r_text,r_time) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataReview>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataReview) {
                    Log.d("messageInsertReview", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageInsertReview",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }


    fun UploadImageUserPresenterRX(
        n_id:String,
        img_pro: File,
        res:(Boolean)-> Unit
    ){
        val encodedImagePic1: String
        var UploadImage = ArrayList<BodyUploadImage.Data>()

        if (img_pro.absolutePath != "") {
            val myBitmap = BitmapFactory.decodeFile(img_pro.absolutePath)

            if (myBitmap != null) {
                Log.d("registerImageMessage", myBitmap.toString())
                val byteArrayOutputStream =
                    ByteArrayOutputStream()
                myBitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    70,
                    byteArrayOutputStream
                )
                val byteArrayImage =
                    byteArrayOutputStream.toByteArray()
                encodedImagePic1 = Base64.encodeToString(
                    byteArrayImage,
                    Base64.DEFAULT
                )
                val uploadData = BodyUploadImage.Data(
                    n_id,img_pro.name,"data:image/jpeg;base64,$encodedImagePic1"
                )
                UploadImage.add(uploadData)

            }
        }
        mDisposable = DataModule.myAppService.doUploadImg(BodyUploadImage(UploadImage))
            .subscribeOn(Schedulers.io())
            .timeout(20, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseUploadImage>(){
                override fun onComplete() {}
                override fun onNext(response: ResponseUploadImage) {
                    if (response.isSuccessful){
                        res.invoke(true)
                        Log.d("registerImageMessage",response.message.toString())
                    }else{
                        res.invoke(false)
                    }
                }
                override fun onError(e: Throwable) {
                    Log.d("registerImageMessage",e.message.toString())
                    res.invoke(false)
                }

            })
    }




    fun UploadProfileUserPR(
        u_id:String,
        u_img: File,
        res:(Boolean)-> Unit
    ){
        val encodedImagePic1: String
        var UploadImagePr = ArrayList<BodyUploadImagePro_Pr.Data>()

        if (u_img.absolutePath != "") {
            val myBitmap = BitmapFactory.decodeFile(u_img.absolutePath)

            if (myBitmap != null) {
                Log.d("registerImagePRMessage", myBitmap.toString())
                val byteArrayOutputStream =
                    ByteArrayOutputStream()
                myBitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    70,
                    byteArrayOutputStream
                )
                val byteArrayImage =
                    byteArrayOutputStream.toByteArray()
                encodedImagePic1 = Base64.encodeToString(
                    byteArrayImage,
                    Base64.DEFAULT
                )
                val uploadData = BodyUploadImagePro_Pr.Data(
                    u_id,u_img.name,"data:image/jpeg;base64,$encodedImagePic1"
                )
                UploadImagePr.add(uploadData)

            }
        }
        mDisposable = DataModule.myAppService.douploadImg_Pr(BodyUploadImagePro_Pr(UploadImagePr))
            .subscribeOn(Schedulers.io())
            .timeout(20, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseUploadImage>(){
                override fun onComplete() {}
                override fun onNext(response: ResponseUploadImage) {
                    if (response.isSuccessful){
                        res.invoke(true)
                        Log.d("registerImageMessage",response.message.toString())
                    }else{
                        res.invoke(false)
                    }
                }
                override fun onError(e: Throwable) {
                    Log.d("registerImageMessage",e.message.toString())
                    res.invoke(false)
                }

            })
    }

    fun UploadImageUserSPresenterRX(
        n_id:String,
        img_pro: List<String>,
        res:(Boolean)-> Unit
    ){
        var encodedImagePic1: String
        var UploadImage = ArrayList<BodyImageS.Data>()
        for (i in img_pro) {
            val  file = File(i)
            if (file.absolutePath != "") {
                val myBitmap = BitmapFactory.decodeFile(file.absolutePath)

                if (myBitmap != null) {
                    Log.d("registerImageMessage", myBitmap.toString())
                    val byteArrayOutputStream =
                        ByteArrayOutputStream()
                    myBitmap.compress(
                        Bitmap.CompressFormat.JPEG,
                        70,
                        byteArrayOutputStream
                    )
                    val byteArrayImage =
                        byteArrayOutputStream.toByteArray()
                    encodedImagePic1 = Base64.encodeToString(
                        byteArrayImage,
                        Base64.DEFAULT
                    )
                    val uploadData = BodyImageS.Data(
                        n_id, file.name, "data:image/jpeg;base64,$encodedImagePic1"
                    )
                    UploadImage.add(uploadData)

                }
            }
        }
        mDisposable = DataModule.myAppService.douploadImg_S(BodyImageS(UploadImage))
            .subscribeOn(Schedulers.io())
            .timeout(20, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseUploadImage>(){
                override fun onComplete() {}
                override fun onNext(response: ResponseUploadImage) {
                    if (response.isSuccessful){
                        res.invoke(true)
                        Log.d("registerImageMessage",response.message.toString())
                    }else{
                        res.invoke(false)
                    }
                }
                override fun onError(e: Throwable) {
                    Log.d("registerImageMessage",e.message.toString())
                    res.invoke(false)
                }

            })
    }



    //RX Delete
    fun DeleteNSRMainPersenterRx(
        id:Int,
        dataResponse : (ResponseDataNsr) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doDeleteNSR(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataNsr>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataNsr) {
                    Log.d("messageDelete", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageDelete",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

//
//
    //RX Update
    fun UpdateNSRMainPersenterRx(
        id:Int,
        n_code:String,
        n_username:String,
        n_password:String,
        n_fname:String,
        n_lname:String,
        n_sex:String,
        n_age:String,
        n_phone:String,
        n_address:String,
        n_email:String,
        n_file_img:String,
        n_status:String,
        dataResponse : (ResponseDataNsr) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doUpdate(id, BodyUpdates(n_code,n_username,
            n_password,
            n_fname,
            n_lname,
            n_sex,
            n_age,
            n_phone,
            n_address,
            n_email,
            n_file_img,
            n_status) )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseDataNsr>(){
                override fun onComplete() {

                }

                override fun onNext(response: ResponseDataNsr) {
                    Log.d("messageUpdate", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageUpdate",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }











}
