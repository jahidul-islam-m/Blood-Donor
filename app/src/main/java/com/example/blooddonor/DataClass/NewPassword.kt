package com.example.blooddonor.DataClass


import com.google.gson.annotations.SerializedName

data class NewPassword(
    @SerializedName("password")
    val password: String?,
    @SerializedName("password_confirmation")
    val passwordConfirmation: String?,
    @SerializedName("phone")
    val phone: String?
)