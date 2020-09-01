package com.example.bbct_rmu.model.response

class ResponseLoginAM : ArrayList<ResponseLoginAMItem>()

data class ResponseLoginAMItem(
    val a_id: Int,
    val a_name: String,
    val a_password: String,
    val a_status: String,
    val a_username: String
)