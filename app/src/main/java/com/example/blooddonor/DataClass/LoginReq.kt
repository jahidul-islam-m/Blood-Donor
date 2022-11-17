package com.example.blooddonor.DataClass


import com.google.gson.annotations.SerializedName

data class LoginReq(
    @SerializedName("password")
    val password: String?,
    @SerializedName("phone")
    val phone: String?
)