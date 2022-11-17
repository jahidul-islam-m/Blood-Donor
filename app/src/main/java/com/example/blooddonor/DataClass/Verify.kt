package com.example.blooddonor.DataClass


import com.google.gson.annotations.SerializedName

data class Verify(
    @SerializedName("code")
    val code: String?,
    @SerializedName("phone")
    val phone: String?
)