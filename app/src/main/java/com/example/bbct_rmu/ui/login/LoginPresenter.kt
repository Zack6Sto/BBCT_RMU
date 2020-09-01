package com.example.bbct_rmu.ui.login

import android.util.Log
import com.example.bbct_rmu.model.body.BodyLogin
import com.example.bbct_rmu.model.body.BodyLoginAM
import com.example.bbct_rmu.model.body.BodyLoginNSR
import com.example.bbct_rmu.model.response.*
import com.example.bbct_rmu.rest.DataModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LoginPresenter {

    var mDisposable: Disposable? = null


    fun LoginPRPersenterRx(
        user:String,
        pass:String,
        Status:String,

        dataResponse : (ResponseLogin) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doLogin(BodyLogin(user,pass,Status))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseLogin>(){
                override fun onComplete() {

                }

                override fun onNext(responseLogin: ResponseLogin) {
                    Log.d("Login", responseLogin.toString())
                    dataResponse.invoke(responseLogin)
                }

                override fun onError(e: Throwable) {
                    Log.d("Login",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }



    fun LoginNsrPersenter(
        user:String,
        pass:String,
        Status:String,
        dataResponse : (ResponseLoginNSR) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.doLoginNSR(BodyLoginNSR(user,pass,Status))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ResponseLoginNSR>(){
                override fun onComplete() {

                }

                override fun onNext(responseLogin: ResponseLoginNSR) {
                    Log.d("message", responseLogin.toString())
                    dataResponse.invoke(responseLogin)
                }

                override fun onError(e: Throwable) {
                    Log.d("message",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }


    //    Get IMG PR
    fun MainSearchImgPrPersenterRx(
        id:Int,
        dataResponse : (List<ResponseDataImgPr>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.dosearchImgPr(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataImgPr>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataImgPr>) {
                    Log.d("messageIMGPr", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageIMGPr",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }

    //    Get IMG NSR
    fun MainSearchImgNsrPersenterRx(
        id:Int,
        dataResponse : (List<ResponseDataImgNsr>) -> Unit,
        MessageError: (String)-> Unit
    ){

        mDisposable = DataModule.myAppService.dosearchImgNsr(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<List<ResponseDataImgNsr>>(){
                override fun onComplete() {

                }

                override fun onNext(response: List<ResponseDataImgNsr>) {
                    Log.d("messageIMGNsr", response.toString())
                    dataResponse.invoke(response)
                }

                override fun onError(e: Throwable) {
                    Log.d("messageIMGNsr",e.toString())
                    MessageError.invoke(e.message!!)
                }

            })

    }



}