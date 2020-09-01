package com.example.bbct_rmu.model.response

import android.os.Message

data class ResponseUploadImage (
    val isSuccessful: Boolean,
    val message: String?
)