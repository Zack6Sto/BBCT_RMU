package com.example.bbct_rmu.model.response


class ResponseDataPr (
    val u_id: Int,
    val u_code: String,
    val u_username: String,
    val u_password: String,
    val u_fname: String,
    val u_lname: String,
    val u_age: String,
    val u_phone: String,
    val u_email: String,
    val u_status: String,
    val u_add:String
)

class ResponseDataNsr(
    val n_id: String,
    var n_code: String,
    val n_username: String,
    val n_password: String,
    val n_fname: String,
    val n_lname: String,
    val n_sex: String,
    val n_age: String,
    val n_phone: String,
    val n_address: String,
    val n_email: String,
    val n_status: String,
    val n_add:String

)

data class ResponseDataShowNsr(
    val n_id: Int,
    var n_code: String,
    val n_username: String,
    val n_password: String,
    val n_fname: String,
    val n_lname: String,
    val n_sex: String,
    val n_age: String,
    val n_phone: String,
    val n_address: String,
    val n_email: String,
    val n_status: String,
    val n_add:String,
    val img :String
)

data class ResponseDataPost(
    val p_id:String,
    val u_id: Int,
    val p_text:String,
    val p_time:String,
    val username:String,
    val img :String
)

data class ResponseDataComment (
    val p_id: String,
    val u_id: String,
    val name_cm:String,
    val img_cm:String,
    val cm_text:String,
    val cm_time:String
)

data class ResponseDataReview (
    val n_id: String,
    val u_id: String,
    val name_review:String,
    val img_review:String,
    val r_text:String,
    val r_time:String

)

data class ResponseDataImgPr(
    val img_u_id:Int,
    val u_id:String,
    val u_img:String
)

data class ResponseDataImgNsr(
    val id_img_pro:Int,
    val n_id: String,
    val img_pro:String
)

data class ResponseDataImg(
    val img_id:Int,
    val n_id: String,
    val img_normal:String
)
data class ResponseImageData(
    val img: String
)