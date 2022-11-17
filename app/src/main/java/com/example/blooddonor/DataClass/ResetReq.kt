package com.example.blooddonor.DataClass


import com.google.gson.annotations.SerializedName

data class ResetReq(
    @SerializedName("phone")
    val phone: String?
)