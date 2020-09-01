package com.example.bbct_rmu.model.body


data class BodyLogin(
    val u_username: String,
    val u_password: String,
    val u_status: String
)

data class BodyLoginAM(
    val a_username: String,
    val a_password: String,
    val a_status: String
)

data class BodyLoginNSR(
    val n_username: String,
    val n_password: String,
    val n_status: String
)

