package com.example.bbct_rmu.model.response

class ResponseLoginNSR : ArrayList<ResponseLoginNSRItem>()

data class ResponseLoginNSRItem(
    val n_address: String,
    val n_age: String,
    val n_code: String,
    val n_email: String,
    val n_file_img: String,
    val n_fname: String,
    val n_id: Int,
    val n_lname: String,
    val n_password: String,
    val n_phone: String,
    val n_sex: String,
    val n_status: String,
    val n_username: String
)