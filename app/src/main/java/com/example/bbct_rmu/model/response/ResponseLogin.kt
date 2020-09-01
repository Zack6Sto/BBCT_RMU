package com.example.bbct_rmu.model.response

class ResponseLogin : ArrayList<ResponseLoginPRItem>()

data class ResponseLoginPRItem(
    val u_age: String,
    val u_code: String,
    val u_email: String,
    val u_fname: String,
    val u_id: Int,
    val u_lname: String,
    val u_password: String,
    val u_phone: String,
    val u_status: String,
    val u_username: String,
    val u_add:String
)


