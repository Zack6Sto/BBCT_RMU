package com.example.bbct_rmu.rest


import com.example.bbct_rmu.model.body.*
import com.example.bbct_rmu.model.response.*
import io.reactivex.Observable
import retrofit2.http.*


interface ServiceAPI {

    @POST("/uploadImg")
    fun doUploadImg(@Body bodyUpload: BodyUploadImage): Observable<ResponseUploadImage>

    @POST("/uploadImg_Pr")
    fun douploadImg_Pr(@Body bodyUpload: BodyUploadImagePro_Pr): Observable<ResponseUploadImage>

    @POST("/uploadImg_S")
    fun douploadImg_S(@Body bodyUpload: BodyImageS): Observable<ResponseUploadImage>

    //**************************************************************************
    //*LOGIN*\\
    //**************************************************************************
    @POST("/loginParent")
    fun doLogin(@Body body: BodyLogin?):Observable<ResponseLogin>

    @POST("/loginAdmin")
    fun doLoginAM(@Body body: BodyLoginAM?):Observable<ResponseLoginAM>

    @POST("/loginNursery")
    fun doLoginNSR(@Body body: BodyLoginNSR?):Observable<ResponseLoginNSR>
    //**************************************************************************


    //**************************************************************************
    //*GET*\\
    //**************************************************************************
    @GET("/nursery")
    fun doGetNSR(): Observable<List<ResponseDataShowNsr>>

    @GET("/listpost")
    fun doGetPost(): Observable<List<ResponseDataPost>>

    @GET("/listComment/{id}")
    fun doGetComment(@Path("id") id:Int?): Observable<List<ResponseDataComment>>

    @GET("/listReview/{id}")
    fun doGetReview(@Path("id") id:Int?): Observable<List<ResponseDataReview>>

    @GET("/searchImgPr/{id}")
    fun dosearchImgPr(@Path("id")id: Int?): Observable<List<ResponseDataImgPr>>

    @GET("/searchImgNsr/{id}")
    fun dosearchImgNsr(@Path("id")id: Int?): Observable<List<ResponseDataImgNsr>>

    @GET("/searchImg/{id}")
    fun dosearchImg(@Path("id")id: Int?): Observable<List<ResponseDataImg>>

    @GET("/dataNSRItem/{id}")
    fun dodataNSRItem(@Path("id")id: Int?): Observable<List<ResponseDataShowNsr>>

//    @GET("/listComment/:id")
//    fun doGetCommentID(): Observable<List<ResponseDataComment>>
    //**************************************************************************

    //**************************************************************************
    //*INSERT*\\
    //**************************************************************************
    @POST("/RegisterParent")
    fun doInsertPR(@Body body: BodyInsert?):Observable<ResponseDataPr>

    @POST("/RegisterNursery")
    fun doInsertNSR(@Body body: BodyInsertNSR?):Observable<ResponseNSR>

    @POST("/Post")
    fun doInsertPost(@Body body: BodyInsertPost?):Observable<ResponseDataPost>

    @POST("/Comment")
    fun doInsertComment(@Body body: BodyInsertComment?):Observable<ResponseDataComment>

    @POST("/Review")
    fun doInsertReview(@Body body: BodyInsertReview?):Observable<ResponseDataReview>
    //**************************************************************************



    @PUT("/updateNsr/{id}")
    fun doUpdate(@Path("id")id:Int,
                 @Body body: BodyUpdates?):Observable<ResponseDataNsr>

    @DELETE("/deleteNsr/{id}")
    fun doDeleteNSR(@Path("id")id:Int):Observable<ResponseDataNsr>




}