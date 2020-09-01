package com.example.bbct_rmu.model.response

data class ResponseNSR(
    val message: Message,
    val n_id: Int,
    val status: Int
)

data class Message(
    val n_add: String,
    val n_address: String,
    val n_age: String,
    val n_code: String,
    val n_email: String,
    val n_fname: String,
    val n_lname: String,
    val n_password: String,
    val n_phone: String,
    val n_sex: String,
    val n_status: String,
    val n_username: String
)


