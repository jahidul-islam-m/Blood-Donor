package com.example.blooddonor.DataClass


import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email")
    val email: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("password_confirmation")
    val passwordConfirmation: String?,
    @SerializedName("phone")
    val phone: String?
)